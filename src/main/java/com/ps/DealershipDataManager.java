package com.ps;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DealershipDataManager {
    private DataSource dataSource;

    public DealershipDataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles";

        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                int vin = resultSet.getInt("vin");
                int year = resultSet.getInt("year");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String vehicleType1 = resultSet.getString("vehicle_type");
                Vehicle.VehicleType vehicleType;
                try {
                    vehicleType = Vehicle.VehicleType.valueOf(vehicleType1.toLowerCase());
                } catch (IllegalArgumentException | NullPointerException e) {
                    System.err.println("Invalid vehicle type in database " + vehicleType1);
                    continue;
                }
                String color = resultSet.getString("color");
                int odometer = resultSet.getInt("odometer");
                int price = resultSet.getInt("price");

                allVehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allVehicles;
    }

    public void updateVehicles(Vehicle vehicle) {
        String query = "UPDATE vehicles SET year = ?, make = ?, model = ?, vehicle_type = ? , color = ?, odometer = ? ,price = ? WHERE vin = ?";

        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, vehicle.getYear());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setString(4, vehicle.getVehicleType().name());
            preparedStatement.setString(5, vehicle.getColor());
            preparedStatement.setInt(6, vehicle.getOdometer());
            preparedStatement.setFloat(7, vehicle.getPrice());
            preparedStatement.setInt(8,vehicle.getVin());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0){
                System.out.println("rows updated " + rowsUpdated);
            } else {
            System.out.println("No rows updated");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
