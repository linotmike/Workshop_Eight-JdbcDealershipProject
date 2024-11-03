package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.StringReader;

public class ContractFileManager {

    public void readContracts() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("contract.csv"));

            String firstLine;
            while ((firstLine = bufferedReader.readLine()) != null) {
                String[] contractDetails = firstLine.split("\\|");

                String contractType = contractDetails[0];
                Contract contract = null;

                if ("Sale".equalsIgnoreCase(contractType)) {
                    contract = parseSalesContract(contractDetails);
                } else if ("Lease".equalsIgnoreCase(contractType)) {
                    contract = parseLeaseContract(contractDetails);
                }
                if (contract != null) {
                    System.out.println(contract);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SalesContract parseSalesContract(String[] contractDetails) {
//        Vehicle vehicle;
        String date = contractDetails[1];
        String name = contractDetails[2];
        String email = contractDetails[3];
        int vin = Integer.parseInt(contractDetails[4]);
        int year = Integer.parseInt(contractDetails[5]);
        String make = contractDetails[6];
        String model = contractDetails[7];
        Vehicle.VehicleType vehicleType = Vehicle.VehicleType.valueOf(contractDetails[8].toLowerCase());
        String color = contractDetails[9];
        int odometer = Integer.parseInt(contractDetails[10]);
        float price = Float.parseFloat(contractDetails[11]);
        double salesTaxAmount = Double.parseDouble(contractDetails[12]);
        float recordingFee = Float.parseFloat(contractDetails[13]);
//        Vehicle vehicleSold = Vehicle.
        float processingFee = Float.parseFloat(contractDetails[14]);
        //totalPrice
        boolean finance = "YES".equalsIgnoreCase(contractDetails[16]);
        //monthlyPrice
        Vehicle vehicleSold = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        SalesContract salesContract = new SalesContract(date, name, email, vehicleSold, finance);
//        Vehicle vehicleSold = contractDetails[14];

        salesContract.setSalesTaxAmount(salesTaxAmount);
        salesContract.setRecordingFee(recordingFee);
        salesContract.setProcessingFee(processingFee);


        double totalPrice = salesContract.getTotalPrice();
        double monthlyPayment = salesContract.getMonthlyPayment();

        contractDetails[15] = String.valueOf(totalPrice);
        contractDetails[17] = String.valueOf(monthlyPayment);


        return salesContract;
    }

    private LeaseContract parseLeaseContract(String[] contractDetails) {
        return null;
    }
}
