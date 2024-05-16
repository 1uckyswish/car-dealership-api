package com.pluralsight.dealership.models;

/**
 * The SaleContract class represents a contract for a vehicle sale.
 * It extends the Contract class and inherits its properties and methods.
 */
public class SaleContract extends Contract {

    /**
     * Constructs a new SaleContract object with the specified sales ID and vehicle ID.
     *
     * @param salesID   The ID of the sale contract.
     * @param vehicleID The ID of the vehicle associated with the sale contract.
     */
    public SaleContract(String salesID, String vehicleID) {
        super(salesID, vehicleID);
    }

    /**
     * Returns the sales ID associated with this sale contract.
     *
     * @return The sales ID.
     */
    @Override
    public String getSalesID() {
        return super.getSalesID();
    }

    /**
     * Sets the sales ID associated with this sale contract.
     *
     * @param salesID The sales ID to set.
     */
    @Override
    public void setSalesID(String salesID) {
        super.setSalesID(salesID);
    }

    /**
     * Returns the vehicle ID associated with this sale contract.
     *
     * @return The vehicle ID.
     */
    @Override
    public String getVehicleID() {
        return super.getVehicleID();
    }

    /**
     * Sets the vehicle ID associated with this sale contract.
     *
     * @param vehicleID The vehicle ID to set.
     */
    @Override
    public void setVehicleID(String vehicleID) {
        super.setVehicleID(vehicleID);
    }
}
