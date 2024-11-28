package main.java.com.ps;

public class LeaseContract extends Contract {

    private double originalPrice;
    private double expectedEndingValue;
    private double downPayment;
    private double leaseFee;
    private double interestRate;
    private double leaseTermMonths;
    private double monthlyPayment = 0;


    public LeaseContract(String date, String name, String email, Vehicle vehicle, double originalPrice, double downPayment) {
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

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double calculatedMonthly() {
        double principal = originalPrice - expectedEndingValue;
        double montlyInterestRate = interestRate /12 /100;

        return (principal * montlyInterestRate) / (1 - Math.pow(1 + montlyInterestRate, -leaseTermMonths));
    }

    @Override
    public double getTotalPrice() {
        //Total Price=downPayment+leaseFee+(originalPrice−expectedEndingValue)
        return downPayment + leaseFee + (originalPrice - expectedEndingValue);

    }

    public double getMonthlyPayment() {
        if (monthlyPayment != 0) {
            return monthlyPayment;
        }
            return calculatedMonthly();


    }

    @Override
    public String toString() {
        return String.format(
                "Lease | Date: %s | Name: %s | Email: %s | VIN: %d | Year: %d | Make: %s | Model: %s | " +
                        "Type: %s | Color: %s | Odometer: %d | Price: $%.2f | OriginalPrice: $%.2f | Expected Ending Value: $%.2f | " +
                        "Down Payment: $%.2f |  " + "Monthly Payment: $%.2f",
                getDate(), getName(), getEmail(), getVehicle().getVin(), getVehicle().getYear(),
                getVehicle().getMake(), getVehicle().getModel(), getVehicle().getVehicleType(), getVehicle().getColor(),
                getVehicle().getOdometer(), getVehicle().getPrice(), originalPrice, expectedEndingValue,
                downPayment, getMonthlyPayment()
        );
    }
}
