package com.ps;

import java.util.ArrayList;

public abstract class Contract {
    private String date;
    private String name;
    private String email;
    private Vehicle vehicle;

    public Contract(String date, String name, String email, Vehicle vehicle) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;


    }

    abstract public double getTotalPrice();


    abstract public double getMonthlyPayment();


    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
