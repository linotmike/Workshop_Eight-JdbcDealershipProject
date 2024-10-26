package com.ps;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);

    private static Dealership dealership;

    public static void init() {
        dealership = DealershipFileManager.getDealership();

    }

    public static void display() {
        init();

        int menuCommand;
        do{
            System.out.println("Welcome to the car Dealership");
            System.out.println("Please select an option");
            System.out.println("1) Find vehicles By Price range");
            System.out.println("2) Find vehicles By Make/model");
            System.out.println("3) Find vehicles By year");
            System.out.println("4) Find vehicles By Color");
            System.out.println("5) Find vehicles By Mileage range");
            System.out.println("6) Find vehicles By vehicle Type");
            System.out.println("7) All vehicles");
            System.out.println("8) Add a vehicles");
            System.out.println("9) Remove a vehicles");
            System.out.println("99)Quit");
            menuCommand = scanner.nextInt();

            switch(menuCommand){
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
                   //SearchByVehicleType();
                    break;
                case 7:
                   //allVehicles();
                    break;
                case 8:
                    //addAVehicle();
                    break;
                case 9:
                    //removeAVehicle();
                    break;
                case 99:
                    System.out.println("you choose to Quit");
                    break;
                default:
                    System.out.println("please try again command not found");


            }



        }while(menuCommand !=99);


    }

    private static void searchByPriceRange(){
        System.out.println("Please enter a minimum price");
        float minPrice = scanner.nextFloat();

        System.out.println("Please enter a maximum price");
        float maxPrice = scanner.nextFloat();

        List<Vehicle> results = dealership.getVehiclesByPrice(minPrice,maxPrice);
        displayResults(results);
//        scanner.nextLine();

    }

    private static void searchByMakeModel(){

        scanner.nextLine();
        System.out.println("Please enter the make of the car");
        String make = scanner.nextLine().toUpperCase();
        System.out.println("Please enter the model of the car");
        String model = scanner.nextLine().toUpperCase();
        List<Vehicle>results = dealership.getVehiclesByMakeModel(make,model);
        displayResults(results);
    }

    private static void searchByYear(){
        System.out.println("Please enter the minimum year the car was made");
        int minYear = scanner.nextInt();
        System.out.println("Please enter the maximum year the car was made");
        int maxYear = scanner.nextInt();
        List<Vehicle>results = dealership.getVehiclesByYear(minYear,maxYear);
        displayResults(results);
    }

    private static void searchByColor(){
        System.out.println("Please enter the color of the car");
        scanner.nextLine();
        String color = scanner.nextLine();
        List<Vehicle> results = dealership.getVehiclesByColor(color);
        displayResults(results);

    }
    private static void searchByMileageRange(){
        System.out.println("Please enter the minimum mileage");
        int minMileage = scanner.nextInt();
        System.out.println("Please enter the maximum mileage");
        int maxMileage = scanner.nextInt();
        List<Vehicle> results = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayResults(results);
    }



    private static void displayResults(List<Vehicle> results){
        if(results.isEmpty()){
            System.out.println("There is no vehicle");
        }
         for (Vehicle vehicle: results){
             System.out.println(results);
         }
    }
}
