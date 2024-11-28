package main.java.com.ps;


import java.io.*;
import java.util.List;


public class DealershipFileManager {


    public static Dealership getDealership() {
        Dealership dealership = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
//            System.out.println("File found and opened");
            String firstLine = bufferedReader.readLine();
//            if(firstLine != null){

            System.out.println(firstLine);
            String[] dealershipDetails = firstLine.split("\\|");
            String name = dealershipDetails[0];
            String address = dealershipDetails[1];
            String phone = dealershipDetails[2];
            dealership = new Dealership(name, address, phone);
//            } else {
//            System.out.println("File is empty");
//            return null;
//            }
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
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

            return dealership;

        } catch (IOException e) {
            System.out.println("Error reading the file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("error processing the file");
            e.printStackTrace();
        }
        return null;


    }

    public static void saveDealership(Dealership dealership) {
        try {
//            String firstLine;
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory.csv"));
            String firstLine = String.format("%s|%s|%s\n",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone());
            bufferedWriter.write(firstLine);

            List<Vehicle> vehicles = dealership.getAllVehicles();
            for(Vehicle vehicle: vehicles){
                String secondLine = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
                bufferedWriter.write(secondLine);
            }
            bufferedWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error error error");
        }


    }

}
