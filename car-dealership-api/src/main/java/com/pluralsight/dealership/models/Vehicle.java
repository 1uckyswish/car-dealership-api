package com.pluralsight.dealership.models;

import java.text.DecimalFormat;

public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private String type;
    private String color;
    private int odometer;
    private double price;
    private String sold;

    public Vehicle(String vin, int year, String make, String model, String type, String color, int odometer, double price, String sold) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    /**
     * Formatted way to display the attributes in a well-structured way for user to read
     *
     * @return String
     */
    @Override
    public String toString() {
        String padding = " ";
        String line = "═════════════════════════════════════════";

        // Format the price with two decimal places and commas for a thousand separators
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        String formattedPrice = formatter.format(price);

        // Format the odometer reading with commas
        DecimalFormat odometerFormatter = new DecimalFormat("#,###");
        String formattedOdometer = odometerFormatter.format(odometer);

        StringBuilder formattedString = new StringBuilder();
        formattedString.append("╔").append(line).append("╗\n");
        formattedString.append("║").append(padding).append("VIN: ").append(vin).append("\n");
        formattedString.append("║").append(padding).append("Year: ").append(year).append("\n");
        formattedString.append("║").append(padding).append("Make: ").append(make).append("\n");
        formattedString.append("║").append(padding).append("Model: ").append(model).append("\n");
        formattedString.append("║").append(padding).append("Vehicle Type: ").append(type).append("\n");
        formattedString.append("║").append(padding).append("Color: ").append(color).append("\n");
        formattedString.append("║").append(padding).append("Odometer: ").append(formattedOdometer).append(" miles\n");
        formattedString.append("║").append(padding).append("Price: $").append(formattedPrice).append("\n");
        formattedString.append("╚").append(line).append("╝");

        return formattedString.toString();
    }
}