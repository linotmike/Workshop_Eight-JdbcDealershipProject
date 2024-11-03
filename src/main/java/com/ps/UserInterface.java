package com.ps;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.ps.DealershipFileManager.saveDealership;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    private static Dealership dealership;


    public static void init() {
        dealership = DealershipFileManager.getDealership();
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.readContracts();

    }

    public static void display() {
        init();
        int menuCommand;
        do {
            displayMenu();
            menuCommand = scanner.nextInt();

            switch (menuCommand) {
                case 1:
                    searchByPriceRange();
                    break;
                case 2:
                    searchByMakeModel();
                    break;
                case 3:
                    searchByYear();
                    break;
                case 4:
                    searchByColor();
                    break;
                case 5:
                    searchByMileageRange();
                    break;
                case 6:
                    searchByVehicleType();
                    break;
                case 7:
                    searchByVin();
                    break;
                case 8:
                    allVehicles();
                    break;
                case 9:
                    addVehicle();
                    break;
                case 10:
                    removeVehicle();
                    break;
                case 11:
                    sellLeaseVehicle();
                    break;
                case 99:
                    System.out.println("you choose to Quit");
                    break;
                default:
                    System.out.println("please try again command not found");


            }


        } while (menuCommand != 99);

    }

    private static void displayMenu() {
        System.out.println("Please select an option");
        System.out.println("1) Find vehicles By Price range");
        System.out.println("2) Find vehicles By Make/model");
        System.out.println("3) Find vehicles By year");
        System.out.println("4) Find vehicles By Color");
        System.out.println("5) Find vehicles By Mileage range");
        System.out.println("6) Find vehicles By vehicle Type");
        System.out.println("7) Find vehicles by vin");
        System.out.println("8) All vehicles");
        System.out.println("9) Add a vehicles");
        System.out.println("10) Remove a vehicles");
        System.out.println("11) Sell/Lease a vehicle");
        System.out.println("99)Quit");
    }


    private static void searchByPriceRange() {
        System.out.println("Please enter a minimum price");
        float minPrice = scanner.nextFloat();

        System.out.println("Please enter a maximum price");
        float maxPrice = scanner.nextFloat();

        List<Vehicle> results = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayResults(results);
//        System.out.println(Vehicle.VehicleType.getDescription());
//        scanner.nextLine();

    }

    private static void searchByMakeModel() {

        scanner.nextLine();
        System.out.println("Please enter the make of the car");
        String make = scanner.nextLine().toUpperCase();
        System.out.println("Please enter the model of the car");
        String model = scanner.nextLine().toUpperCase();
        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayResults(results);
    }

    private static void searchByYear() {
        System.out.println("Please enter the minimum year the car was made");
        int minYear = scanner.nextInt();
        System.out.println("Please enter the maximum year the car was made");
        int maxYear = scanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByYear(minYear, maxYear);
        displayResults(results);
    }

    private static void searchByColor() {
        System.out.println("Please enter the color of the car");
        scanner.nextLine();
        String color = scanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByColor(color);
        displayResults(results);

    }

    private static void searchByMileageRange() {
        System.out.println("Please enter the minimum mileage");
        int minMileage = scanner.nextInt();
        System.out.println("Please enter the maximum mileage");
        int maxMileage = scanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayResults(results);
    }

    private static void searchByVehicleType() {
        scanner.nextLine();
        boolean validInput = false;
        Vehicle.VehicleType type = null;
        while (!validInput) {
            System.out.println("Please enter the type of the vehicle");
            String vehicle = scanner.nextLine().toLowerCase();
            try {
                type = Vehicle.VehicleType.valueOf(vehicle);
                validInput = true;
            } catch (IllegalArgumentException e) {
//            e.printStackTrace();
                System.out.println("Invalid vehicle type. Please enter a valid vehicle Type");
//            searchByVehicleType();
            }
        }
        List<Vehicle> results = dealership.getVehiclesByType(type);
        displayResults(results);
    }

    private static void searchByVin() {
        System.out.println("Enter the vin");
        int vin = scanner.nextInt();
        List<Vehicle> result = dealership.getVehicleByVin(vin);
        displayResults(result);

    }

    private static void addVehicle() {
        System.out.println("Enter the vin");
        int vin = scanner.nextInt();
        System.out.println("Enter the year");
        int year = scanner.nextInt();
        System.out.println("Enter the make");
        scanner.nextLine();
        String make = scanner.nextLine();
        System.out.println("Enter the model");
        String model = scanner.nextLine();
        System.out.println("Enter the vehicle type(car,truck,suv,convertible)");
        String type = scanner.nextLine();
        System.out.println("Enter the color");
        String color = scanner.nextLine();
        System.out.println("Enter the odometer");
        int odometer = scanner.nextInt();
        System.out.println("Enter the price");
        float price = scanner.nextFloat();
        try {
            Vehicle.VehicleType vehicleType = Vehicle.VehicleType.valueOf(type);
            Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            System.out.println("Vehicle added " + vehicle + vehicleType.getAddDescription());
            dealership.addVehicle(vehicle);
            saveDealership(dealership);
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.println("Invalid Vehicle type");
        }
    }

    private static void removeVehicle() {

        System.out.println("Enter the vin of the vehicle to remove");
        int vin = scanner.nextInt();
        scanner.nextLine();
        Vehicle removeVehicle = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                removeVehicle = vehicle;
                break;
            }
        }
        if (removeVehicle != null) {
            dealership.removeVehicle(removeVehicle);
            System.out.println("vehicle removed: " + removeVehicle);
        } else {
            System.out.println("No vehicle found to remove");
        }
    }

    private static void allVehicles() {

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle + vehicle.getVehicleType().getViewDescription());
        }
    }

    public static void sellLeaseVehicle() {
        System.out.println("would you like to sell or lease 1) sell 2)lease");
        int response = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Available vehicles");
        for (Vehicle vehicle : dealership.getAllVehicles())
            System.out.println(vehicle);
        System.out.println("please enter the vin of the vehicle you would like");
        int vin = scanner.nextInt();
        scanner.nextLine();
//        scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByVin(vin);
        Vehicle vehicle = vehicles.get(0);

//        Vehicle vehicle = (Vehicle) dealership.getVehicleByVin(vin);
        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }
//        scanner.nextLine();
        System.out.println("enter the date");
        String date = LocalDate.now().toString();
        scanner.nextLine();
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        Contract contract;
        if (response == 1) {
            System.out.println("Do you want to finance 1)Yes 2)No");
            int financeResponse = scanner.nextInt();
            scanner.nextLine();
            boolean finance = (financeResponse == 1);
            contract = new SalesContract(date, name, email, vehicle, finance);
            System.out.println("Sales contract added" + contract);
        } else if(response ==2){
            System.out.println("Enter the original price");
            double originalPrice = scanner.nextDouble();
            System.out.println("Enter the down payment amount");
            double downPayment = scanner.nextDouble();

            contract = new LeaseContract(date,name,email,vehicle,originalPrice,downPayment);
            System.out.println("Lease contract added " + contract);

        } else {
            System.out.println("Invalid option");

        }



    }


    private static void displayResults(List<Vehicle> results) {
        if (results.isEmpty()) {
            System.out.println("There is no vehicle");
        }
        for (Vehicle vehicle : results) {
            System.out.println(results + vehicle.getVehicleType().getViewDescription());
        }
    }

//    public static void displayVehicleType(List<Vehicle> vehicles){
//        for(Vehicle vehicle: vehicles){
//            System.out.println(vehicle + vehicle.getVehicleType().getDescription());
//        }
//
//    }
}
