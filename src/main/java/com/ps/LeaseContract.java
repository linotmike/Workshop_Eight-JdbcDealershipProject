package com.ps;

public class LeaseContract extends Contract{

    private double originalPrice;
    private double expectedEndingValue;
    private double downPayment;
    private double leaseFee;
    private double interestRate;
    private double leaseTermMonths;


    public LeaseContract (String date, String name, String email, Vehicle vehicle, double originalPrice, double expectedEndingValue, double downPayment,double leaseFee, double interestRate, double leaseTermMonths){
        super(date,name,email,vehicle);
        this.originalPrice = originalPrice;
        this.expectedEndingValue = originalPrice * 0.50;
        this.downPayment = downPayment;
        this.leaseFee = originalPrice * 0.07;
        this.interestRate = 4.0;
        this.leaseTermMonths = 36;
    }










    public void getTotalPrice(){

    }

    public void getMonthlyPayment(){

    }
}
