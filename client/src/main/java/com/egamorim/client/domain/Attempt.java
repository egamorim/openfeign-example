package com.egamorim.client.domain;

import java.util.Date;
import java.util.UUID;

public class Attempt {

    private String id;
    private Date date;
    private VendorEnum vendor;

    public Attempt(VendorEnum vendor) {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
        this.vendor = vendor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VendorEnum getVendor() {
        return vendor;
    }

    public void setVendor(VendorEnum vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Attempt{" +
            "id='" + id + '\'' +
            ", date=" + date +
            ", vendor='" + vendor + '\'' +
            '}';
    }
}
