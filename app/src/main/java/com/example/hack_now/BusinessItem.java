package com.example.hack_now;

public class BusinessItem {
    String name;
    String desc;
    String service;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getService() {
        return service;
    }

    public BusinessItem(String name, String desc, String service) {
        this.name = name;
        this.desc = desc;
        this.service = service;
    }
}
