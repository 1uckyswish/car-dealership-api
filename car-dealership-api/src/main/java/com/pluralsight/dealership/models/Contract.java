package com.pluralsight.dealership.models;

public class Contract {
    private String salesID;
    private String vehicleID;

    public Contract(String salesID, String vehicleID) {
        this.salesID = salesID;
        this.vehicleID = vehicleID;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "salesID='" + salesID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                '}';
    }
}
