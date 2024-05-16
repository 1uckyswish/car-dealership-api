package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.LeaseContract;

import java.util.List;

/**
 * The LeaseContractDao interface defines methods for accessing and managing lease contracts.
 */
public interface LeaseContractDao {

    /**
     * Retrieves a lease contract by its ID.
     *
     * @param id The ID of the lease contract.
     * @return The lease contract with the specified ID, or null if not found.
     */
    LeaseContract getContractById(String id);

    /**
     * Retrieves a list of all lease contracts.
     *
     * @return A list of lease contracts.
     */
    List<LeaseContract> getAllContracts();

    /**
     * Adds a new lease contract for the vehicle identified by its VIN (Vehicle Identification Number).
     *
     * @param vin The VIN of the vehicle for which the lease contract is added.
     */
    void addContract(String vin);
}
