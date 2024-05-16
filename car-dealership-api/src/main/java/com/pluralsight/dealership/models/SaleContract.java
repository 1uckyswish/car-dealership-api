package com.pluralsight.dealership.models;

public class SaleContract extends Contract{
    public SaleContract(String salesID, String vehicleID) {
        super(salesID, vehicleID);
    }

    @Override
    public String getSalesID() {
        return super.getSalesID();
    }

    @Override
    public void setSalesID(String salesID) {
        super.setSalesID(salesID);
    }

    @Override
    public String getVehicleID() {
        return super.getVehicleID();
    }

    @Override
    public void setVehicleID(String vehicleID) {
        super.setVehicleID(vehicleID);
    }
}
