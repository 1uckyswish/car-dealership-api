package com.pluralsight.dealership.models;

/**
 * The Contract class represents a generic contract.
 * It contains basic information such as sales ID and vehicle ID.
 */
public class Contract {
    private String salesID;
    private String vehicleID;

    /**
     * Constructs a new Contract object with the specified sales ID and vehicle ID.
     *
     * @param salesID   The ID of the contract.
     * @param vehicleID The ID of the vehicle associated with the contract.
     */
    public Contract(String salesID, String vehicleID) {
        this.salesID = salesID;
        this.vehicleID = vehicleID;
    }

    /**
     * Returns the sales ID associated with this contract.
     *
     * @return The sales ID.
     */
    public String getSalesID() {
        return salesID;
    }

    /**
     * Sets the sales ID associated with this contract.
     *
     * @param salesID The sales ID to set.
     */
    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    /**
     * Returns the vehicle ID associated with this contract.
     *
     * @return The vehicle ID.
     */
    public String getVehicleID() {
        return vehicleID;
    }

    /**
     * Sets the vehicle ID associated with this contract.
     *
     * @param vehicleID The vehicle ID to set.
     */
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    /**
     * Returns a string representation of the contract.
     *
     * @return A string containing the sales ID and vehicle ID.
     */
    @Override
    public String toString() {
        return "Contract{" +
                "salesID='" + salesID + '\'' +
                ", vehicleID='" + vehicleID + '\'' +
                '}';
    }
}
