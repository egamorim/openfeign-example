package com.egamorim.client.api;

import com.egamorim.client.domain.Event;
import com.egamorim.client.service.NamesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.INPUT)
public class InputController {

    @Autowired
    private NamesService service;

    @GetMapping
    public ResponseEntity test() {
        Event event = new Event();
        try {
            NamesResponse names = service.getNamesFromResource(event);
            return ResponseEntity.ok(names);
        } catch (Exception e) {
            return ResponseEntity.ok(event);
        }
    }
}
