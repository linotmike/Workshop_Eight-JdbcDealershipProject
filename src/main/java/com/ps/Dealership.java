package com.ps;

import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership() {
        inventory = new ArrayList<>();
    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(float minPrice, float maxPrice) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
       List<Vehicle> results = new ArrayList<>();
       for (Vehicle vehicle: inventory){
           if(vehicle.getMake().equalsIgnoreCase(make)&& vehicle.getModel().equalsIgnoreCase(model)){
               results.add(vehicle);
           }
       }
       return results;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
       List<Vehicle> results = new ArrayList<>();
       for (Vehicle vehicle: inventory){
           if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
               results.add(vehicle);
           }
       }
       return results;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList <>();
        for (Vehicle vehicle: inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        System.out.println("getVehiclesByMileage");
        return new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByType(Vehicle.VehicleType vehicleType) {
        System.out.println("getVehiclesByType");
        return new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }


}
