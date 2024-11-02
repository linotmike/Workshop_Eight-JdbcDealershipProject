package com.ps;

public class LeaseContract extends Contract {

    private double originalPrice;
    private double expectedEndingValue;
    private double downPayment;
    private double leaseFee;
    private double interestRate;
    private double leaseTermMonths;


    public LeaseContract(String date, String name, String email, Vehicle vehicle, double originalPrice, double expectedEndingValue, double downPayment, double leaseFee, double interestRate, double leaseTermMonths) {
        super(date, name, email, vehicle);
        this.originalPrice = originalPrice;
        this.expectedEndingValue = originalPrice * 0.50;
        this.downPayment = downPayment;
        this.leaseFee = originalPrice * 0.07;
        this.interestRate = 4.0;
        this.leaseTermMonths = 36;

    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getLeaseTermMonths() {
        return leaseTermMonths;
    }

    public void setLeaseTermMonths(double leaseTermMonths) {
        this.leaseTermMonths = leaseTermMonths;
    }
    @Override
    public double getTotalPrice() {
        //Total Price=downPayment+leaseFee+(originalPrice−expectedEndingValue)
        return downPayment + leaseFee + (originalPrice - expectedEndingValue);

    }

    public double getMonthlyPayment() {
//        return

    }
}
