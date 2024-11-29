package com.ps;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private VehicleType vehicleType;
    private String color;
    private int odometer;
    private float price;

    public Vehicle(int vin, int year, String make, String model, VehicleType vehicleType, String color, int odometer, float price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public enum VehicleType{
        car{
                @Override
            public String getAddDescription (){
                    return "\nYou added a CAR\n" +
                            "    ______\n" +
                            " __//__||_\\__\n" +
                            "|_          _|\n" +
                            "  (o)----(o)";

            }
            public String getViewDescription (){
                    return "\nThis is a CAR\n" +
                            "    ______\n" +
                            " __//__||_\\__\n" +
                            "|_          _|\n" +
                            "  (o)----(o)";

            }

        },
        truck{
            public String getAddDescription (){
                return "\nYou added a TRUCk\n" +
                        "       _________________\n" +
                        "   ____|               |\\\n" +
                        "  |    |_______________| \\\n" +
                        " [|____|-(o)-------(o)-|\n";

            }
            public String getViewDescription (){
                return "\nThis is a TRUCk\n" +
                        "       _________________\n" +
                        "   ____|               |\\\n" +
                        "  |    |_______________| \\\n" +
                        " [|____|-(o)-------(o)-|\n";
            }

        },
        suv{
            public String getAddDescription (){
                return "\nYou added an SUV\n" +
                        "     ______\n" +
                        " __//____|___\\__\n" +
                        "|_            _|\n" +
                        "  (o)-----(o)";

            }
            public String getViewDescription (){
                return "\nThis is an SUV\n" +
                        "     ______\n" +
                        " __//____|___\\__\n" +
                        "|_            _|\n" +
                        "  (o)-----(o)";

            }

        },
        convertible{
            public String getAddDescription (){
                return "\nYou added a CONVERTIBLE.\n" +
                        "      ______\n" +
                        "     //  ||\\ \\\n" +
                        " ____//___||_\\ \\___\n" +
                        "|_   ______     _|\n" +
                        "  `-(o)-----(o)-'";

            }
            public String getViewDescription (){
                return "\nThis is a CONVERTIBLE.\n" +
                        "      ______\n" +
                        "     //  ||\\ \\\n" +
                        " ____//___||_\\ \\___\n" +
                        "|_   ______     _|\n" +
                        "  `-(o)-----(o)-'";

            }

        };
        public abstract String getAddDescription();
        public abstract String getViewDescription();
    }

    @Override
    public String toString() {
        return "\n{" +
                "\nvin=" + vin +
                ", \nyear=" + year +
                ", \nmake='" + make + '\'' +
                ", \nmodel='" + model + '\'' +
                ", \nvehicleType=" + vehicleType +
                ", \ncolor='" + color + '\'' +
                ", \nodometer=" + odometer +
                ", \nprice=" + price +
                '}';
    }

//    public Vehicle() {
//        super();
//    }
}
