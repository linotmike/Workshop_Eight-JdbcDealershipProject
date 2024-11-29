package com.ps;

import java.io.*;
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


        if (contractDetails.length > 15 && !contractDetails[15].isEmpty()) {
            double totalPrice = Double.parseDouble(contractDetails[15]);
            salesContract.setTotalPrice(totalPrice);
        }
        if (contractDetails.length > 17 && !contractDetails[17].isEmpty()) {
            double monthlyPrice = Double.parseDouble(contractDetails[17]);
            salesContract.setMonthlyPayment(monthlyPrice);
        }


        return salesContract;
    }

    private LeaseContract parseLeaseContract(String[] contractDetails) {
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
        double originalPrice = Double.parseDouble(contractDetails[14]);
        double expectedEndingValue = Double.parseDouble(contractDetails[15]);
        double downPayment = 0;
        if (contractDetails.length > 16 && !contractDetails[16].isEmpty()) {
            downPayment = Double.parseDouble(contractDetails[16]);
        }

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        LeaseContract leaseContract = new LeaseContract(date, name, email, vehicle, originalPrice, downPayment);

        if (contractDetails.length > 17 && !contractDetails[17].isEmpty()) {
            double monthlyPayment = Double.parseDouble(contractDetails[17]);
            leaseContract.setMonthlyPayment(monthlyPayment);
        }

        leaseContract.setExpectedEndingValue(expectedEndingValue);


        return leaseContract;
    }

    public void writeContract(Contract contract){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contract.csv",true))){

            if(contract instanceof SalesContract){
                SalesContract salesContract = (SalesContract) contract;
                bufferedWriter.write(formatSalesContract(salesContract));
                bufferedWriter.newLine();

            } else if(contract instanceof LeaseContract){
                LeaseContract leaseContract = (LeaseContract) contract;
                bufferedWriter.write(formatLeaseContract(leaseContract));
                bufferedWriter.newLine();

            } else {
                System.out.println("unknown contract type");
            }


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private String formatSalesContract (SalesContract salesContract){
        return String.format("Sale | Date: %s | Name: %s | Email: %s | VIN: %d | Year: %d | Make: %s | Model: %s | " +
                        "Type: %s | Color: %s | Odometer: %d | Price: $%.2f | Sales Tax: $%.2f | Recording Fee: $%.2f | " +
                        "Processing Fee: $%.2f | Total Price: $%.2f | Financed: %s | Monthly Payment: $%.2f",
                salesContract.getDate(), salesContract.getName(), salesContract.getEmail(),
                salesContract.getVehicle().getVin(), salesContract.getVehicle().getYear(),
                salesContract.getVehicle().getMake(), salesContract.getVehicle().getModel(),
                salesContract.getVehicle().getVehicleType(), salesContract.getVehicle().getColor(),
                salesContract.getVehicle().getOdometer(), salesContract.getVehicle().getPrice(),
                salesContract.getSalesTaxAmount(), salesContract.getRecordingFee(),
                salesContract.getProcessingFee(), salesContract.getTotalPrice(),
                salesContract.isFinance() ? "Yes" : "No", salesContract.getMonthlyPayment());
    }

    private String formatLeaseContract(LeaseContract leaseContract){
        return String.format("Lease | Date: %s | Name: %s | Email: %s | VIN: %d | Year: %d | Make: %s | Model: %s | " +
                        "Type: %s | Color: %s | Odometer: %d | Price: $%.2f | Original Price: $%.2f | " +
                        "Expected Ending Value: $%.2f | Down Payment: $%.2f | Monthly Payment: $%.2f",
                leaseContract.getDate(), leaseContract.getName(), leaseContract.getEmail(),
                leaseContract.getVehicle().getVin(), leaseContract.getVehicle().getYear(),
                leaseContract.getVehicle().getMake(), leaseContract.getVehicle().getModel(),
                leaseContract.getVehicle().getVehicleType(), leaseContract.getVehicle().getColor(),
                leaseContract.getVehicle().getOdometer(), leaseContract.getVehicle().getPrice(),
                leaseContract.getOriginalPrice(), leaseContract.getExpectedEndingValue(),
                leaseContract.getDownPayment(), leaseContract.getMonthlyPayment());
    }
}
