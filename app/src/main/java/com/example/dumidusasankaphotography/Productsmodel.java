package com.example.dumidusasankaphotography;

public class Productsmodel {

    private  String name;
    private String event;
    private String booking;

    private  Productsmodel(){}

    private  Productsmodel (String name, String event, String booking){
        this.name = name;
        this.event = event;
        this.booking = booking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getBooking() {
        return booking;
    }

    public void setBooking(String booking) {
        this.booking = booking;
    }
}
