package com.ps;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private float recordingFee;
    private float processingFee;
    private boolean finance;
    private double salesInterest;
    private double salesTermMonths;


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

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    @Override
    public void getTotalPrice() {
    }

    public void getMonthlyPayment() {


    }


    @Override
    public String toString() {
        return super.toString() + "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", finance=" + finance +
                '}';
    }
}
