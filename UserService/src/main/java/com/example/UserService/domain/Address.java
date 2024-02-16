package com.example.UserService.domain;

public class Address {
    private String  houseno;
    private String landmark;
    private String street;
    private String city;
    private String pincode;

    public Address(){}

    public Address(String houseno, String landmark, String street, String city, String pincode) {
        this.houseno = houseno;
        this.landmark = landmark;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseno='" + houseno + '\'' +
                ", landmark='" + landmark + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}
