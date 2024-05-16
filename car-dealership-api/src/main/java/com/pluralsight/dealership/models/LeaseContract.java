package com.pluralsight.dealership.models;

/**
 * The LeaseContract class represents a contract for leasing a vehicle.
 * It extends the Contract class and inherits its properties and methods.
 */
public class LeaseContract extends Contract {

    /**
     * Constructs a new LeaseContract object with the specified sales ID and vehicle ID.
     *
     * @param salesID   The ID of the lease contract.
     * @param vehicleID The ID of the vehicle associated with the lease contract.
     */
    public LeaseContract(String salesID, String vehicleID) {
        super(salesID, vehicleID);
    }

    /**
     * Returns the sales ID associated with this lease contract.
     *
     * @return The sales ID.
     */
    @Override
    public String getSalesID() {
        return super.getSalesID();
    }

    /**
     * Sets the sales ID associated with this lease contract.
     *
     * @param salesID The sales ID to set.
     */
    @Override
    public void setSalesID(String salesID) {
        super.setSalesID(salesID);
    }

    /**
     * Returns the vehicle ID associated with this lease contract.
     *
     * @return The vehicle ID.
     */
    @Override
    public String getVehicleID() {
        return super.getVehicleID();
    }

    /**
     * Sets the vehicle ID associated with this lease contract.
     *
     * @param vehicleID The vehicle ID to set.
     */
    @Override
    public void setVehicleID(String vehicleID) {
        super.setVehicleID(vehicleID);
    }
}
