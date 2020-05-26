package com.egamorim.client.integration;

import com.egamorim.client.api.Endpoints;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "resource", url = Endpoints.RESOURCE_SERVER_URL)
public interface ResourceServerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/names")
    List<String> getNames();
}
