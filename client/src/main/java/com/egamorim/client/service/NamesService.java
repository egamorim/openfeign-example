package com.egamorim.client.service;

import com.egamorim.client.api.NamesResponse;
import com.egamorim.client.domain.Attempt;
import com.egamorim.client.domain.Event;
import com.egamorim.client.domain.VendorEnum;
import com.egamorim.client.integration.ResourceServerClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class NamesService {
    @Autowired
    private ResourceServerClient client;

    @Retryable(
        value = { Exception.class },
        maxAttempts = 3,
        backoff = @Backoff(delay = 2000))
    public NamesResponse getNamesFromResource(Event event) {

        Attempt attempt = this.getNextAttempt(event);
        event.addAttempt(attempt);

        System.out.println("event: " + event);
        List<String> names = client.getNames();

        NamesResponse response = new NamesResponse(event);
        response.setNames(names);
        return response;
    }

    public Attempt getNextAttempt(Event event) {
        Attempt attempt;
        if(event.getAttemptList().isEmpty()) {
            attempt = new Attempt(VendorEnum.VENDOR_1);
        } else {
            switch (event.getAttemptList()
                .get(event.getAttemptList().size() - 1)
                .getVendor()) {
                case VENDOR_1:
                    attempt = new Attempt(VendorEnum.VENDOR_2);
                    break;
                default:
                    attempt = new Attempt(VendorEnum.VENDOR_1);
                    break;
            }
        }
        return attempt;
    }

}
