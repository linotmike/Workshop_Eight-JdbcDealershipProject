package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to the car Dealership");
//        UserInterface.display();

        if(args.length !=2 ){
            System.out.println("Application needs two arguments to run: username and password");
            System.exit(1);
        }
        String username  = args[0];
        String password  = args[1];

        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);


        DealershipDataManager dealershipDataManager = new DealershipDataManager(basicDataSource);
//        List<Vehicle> allVehicles = dealershipDataManager.getAllVehicles();
//        System.out.println(allVehicles);
        Vehicle vehicle = new Vehicle(1007,2001,"honda","civic", Vehicle.VehicleType.car,"silver",200341,2000 );
//        dealershipDataManager.updateVehicles(vehicle);
        dealershipDataManager.createVehicle(vehicle);
        System.out.println(vehicle);

    }
}