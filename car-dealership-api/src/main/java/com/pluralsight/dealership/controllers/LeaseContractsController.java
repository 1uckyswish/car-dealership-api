package com.pluralsight.dealership.controllers;

import com.pluralsight.dealership.dao.LeaseContractDao;
import com.pluralsight.dealership.models.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The LeaseContractsController class handles HTTP requests related to lease contracts.
 */
@RestController
@RequestMapping("/lease-contracts")
public class LeaseContractsController {

    private LeaseContractDao leaseContractDao;

    /**
     * Constructs a new LeaseContractsController with the specified LeaseContractDao.
     *
     * @param leaseContractDao The data access object for lease contracts.
     */
    @Autowired
    public LeaseContractsController(LeaseContractDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    /**
     * Retrieves a list of all lease contracts.
     *
     * @return A list of all lease contracts.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<LeaseContract> getAllContracts() {
        return leaseContractDao.getAllContracts();
    }

    /**
     * Adds a new lease contract for the vehicle with the specified VIN.
     *
     * @param vin The VIN (Vehicle Identification Number) of the vehicle to create a lease contract for.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addContract(@RequestParam String vin) {
        leaseContractDao.addContract(vin);
    }

    /**
     * Retrieves the lease contract with the specified ID.
     *
     * @param id The ID of the lease contract to retrieve.
     * @return The lease contract with the specified ID.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public LeaseContract getContractById(@RequestParam String id) {
        return leaseContractDao.getContractById(id);
    }


}
