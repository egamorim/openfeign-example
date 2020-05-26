package com.egamorim.client.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Event {
    private String id;
    private List<Attempt> attemptList;

    public Event() {
        this.id = UUID.randomUUID().toString();
        this.attemptList = new ArrayList<>();
    }

    public void addAttempt(Attempt attempt) {
        this.attemptList.add(attempt);
    }

    public List<Attempt> getAttemptList() {
        return attemptList;
    }

    @Override
    public String toString() {
        return "Event{" +
            "id='" + id + '\'' +
            ", attemptList=" + attemptList +
            '}';
    }
}