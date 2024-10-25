package com.ps;

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
                    //searchByPriceRange();
                    break;
                case 2:
                    //searchByMakeModel();
                    break;
                case 3:
                    //searchByYear();
                    break;
                case 4:
                    //searchByColor();
                    break;
                case 5:
                    //SearchByMilageRange();
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
}
