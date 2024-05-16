package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.SaleContract;

import java.util.List;

/**
 * The SalesContractDao interface defines methods for accessing and managing sales contracts.
 */
public interface SalesContractDao {

    /**
     * Retrieves a sales contract by its ID.
     *
     * @param id The ID of the sales contract.
     * @return The sales contract with the specified ID, or null if not found.
     */
    SaleContract getContractById(String id);

    /**
     * Retrieves a list of all sales contracts.
     *
     * @return A list of sales contracts.
     */
    List<SaleContract> getAllContracts();

    /**
     * Adds a new sales contract for the vehicle identified by its VIN (Vehicle Identification Number).
     *
     * @param vin The VIN of the vehicle for which the sales contract is added.
     */
    void addContract(String vin);
}
