package com.egamorim.resourceserver.api;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ResourceController {

    private static int counter = 0;
    @RequestMapping("names")
    public List getNames() {

        counter++;
        if(counter % 3 != 0){
            throw new RuntimeException("fail");
        }
        String[] names = {"Joao","Jose","Maria"};
        return Arrays.asList(names);
    }
}
