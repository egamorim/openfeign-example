package com.egamorim.client.api;

import com.egamorim.client.domain.Event;
import java.util.List;

public class NamesResponse {

    private Event event;
    private List<String> names;

    public NamesResponse(Event event) {
        this.event = event;
    }
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "NamesResponse{" +
            "event=" + event +
            ", names=" + names +
            '}';
    }
}
