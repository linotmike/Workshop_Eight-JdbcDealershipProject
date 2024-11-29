package com.ps;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private float recordingFee;
    //    private Vehicle vehicleSold;
    private float processingFee;
    private boolean finance;
    private double salesInterest;
    private double salesTermMonths;
    private double totalPrice = 0;
    private double monthlyPayment = 0;


    public SalesContract(String date, String name, String email, Vehicle vehicleSold, boolean finance) {
        super(date, name, email, vehicleSold);
        this.salesTaxAmount = 0.05;
        this.recordingFee = 100;
//        this.processingFee = processingFee;
        calculateProcessingFee(vehicleSold);
        this.finance = finance;

        if (finance) {
            if (vehicleSold.getPrice() >= 10000) {
                this.salesInterest = 4.25;
                this.salesTermMonths = 48;
            } else {
                this.salesInterest = 5.25;
                this.salesTermMonths = 24;
            }
        }

    }

    public void calculateProcessingFee(Vehicle vehicle) {
        if (vehicle.getPrice() > 10000) {
            this.processingFee = 495;
        } else {
            this.processingFee = 295;
        }

    }


    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public float getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(float processingFee) {
        this.processingFee = processingFee;
    }

    public float getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(float recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getSalesInterest() {
        return salesInterest;
    }

    public void setSalesInterest(double salesInterest) {
        this.salesInterest = salesInterest;
    }

    public double getSalesTermMonths() {
        return salesTermMonths;
    }

    public void setSalesTermMonths(double salesTermMonths) {
        this.salesTermMonths = salesTermMonths;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double calculatedTotalPrice() {
        double vehiclePrice = getVehicle().getPrice();
        double taxAmount = vehiclePrice * salesTaxAmount;
        return taxAmount + recordingFee + processingFee + vehiclePrice;


    }

    public double calculatedMonthlyPayment() {
        if (!finance) {
            return 0.00;
        }
        double loanAmount = getVehicle().getPrice() + recordingFee + processingFee;
        double monthlyInterestRate = salesInterest / 12 / 100;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -salesTermMonths));


    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        if (totalPrice != 0) {
            return totalPrice;
        }
        return calculatedTotalPrice();
    }

    public double getMonthlyPayment() {
        if (monthlyPayment != 0) {
            return monthlyPayment;
        }
        return calculatedMonthlyPayment();

    }


    @Override
    public String toString() {
        return String.format(
                "Sales | Date: %s | Name: %s | Email: %s | VIN: %d | Year: %d | Make: %s | Model: %s | " +
                        "Type: %s | Color: %s | Odometer: %d | Price: $%.2f | Sales Tax: $%.2f | Recording Fee: $%.2f | " +
                        "Processing Fee: $%.2f | Total Price: $%.2f | Financed: %s | Monthly Payment: $%.2f",
                getDate(), getName(), getEmail(), getVehicle().getVin(), getVehicle().getYear(),
                getVehicle().getMake(), getVehicle().getModel(), getVehicle().getVehicleType(), getVehicle().getColor(),
                getVehicle().getOdometer(), getVehicle().getPrice(), salesTaxAmount,
                recordingFee, processingFee, getTotalPrice(), finance ? "Yes" : "No", getMonthlyPayment()
        );
    }


}
