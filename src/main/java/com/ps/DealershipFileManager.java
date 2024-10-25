package com.ps;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DealershipFileManager {


    public static Dealership getDealership() {
        Dealership dealership = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String firstLine = bufferedReader.readLine();
            String[] dealershipDetails = firstLine.split("\\|");
            String name = dealershipDetails[0];
            String address = dealershipDetails[1];
            String phone = dealershipDetails[2];
            dealership = new Dealership(name, address, phone);
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] vehicleDetails = input.split("\\|");
                int vin = Integer.parseInt(vehicleDetails[0]);
                int year = Integer.parseInt(vehicleDetails[1]);
                String make = vehicleDetails[2];
                String model = vehicleDetails[3];
                Vehicle.VehicleType vehicleType = Vehicle.VehicleType.valueOf(vehicleDetails[4].toLowerCase());
                String color = vehicleDetails[5];
                int odometer = Integer.parseInt(vehicleDetails[6]);
                float price = Float.parseFloat(vehicleDetails[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);


            }
            bufferedReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;


    }


}
