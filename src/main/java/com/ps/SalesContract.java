package com.ps;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private float recordingFee;
    private float processingFee;
    private boolean finance;


    public SalesContract(String date, String name, String email,Vehicle vehicle, double salesTaxAmount, float processingFee,boolean finance){
        super(date, name,email,vehicle);
        this.salesTaxAmount = 0.05;
        this.recordingFee = 100;
        this.processingFee = processingFee;
        this.finance = finance;

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
