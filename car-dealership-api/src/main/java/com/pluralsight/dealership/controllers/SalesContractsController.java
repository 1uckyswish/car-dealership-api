package com.pluralsight.dealership.controllers;

import com.pluralsight.dealership.dao.SalesContractDao;
import com.pluralsight.dealership.models.SaleContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The SalesContractsController class handles HTTP requests related to sales contracts.
 */
@RestController
@RequestMapping("/sales-contracts")
public class SalesContractsController {

    private SalesContractDao salesContractDao;

    /**
     * Constructs a new SalesContractsController with the specified SalesContractDao.
     *
     * @param salesContractDao The data access object for sales contracts.
     */
    @Autowired
    public SalesContractsController(SalesContractDao salesContractDao) {
        this.salesContractDao = salesContractDao;
    }

    /**
     * Retrieves a list of all sales contracts.
     *
     * @return A list of all sales contracts.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<SaleContract> getAllContracts() {
        return salesContractDao.getAllContracts();
    }

    /**
     * Adds a new sales contract for the vehicle with the specified VIN.
     *
     * @param vin The VIN (Vehicle Identification Number) of the vehicle to create a sales contract for.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addContract(@RequestParam String vin) {
        salesContractDao.addContract(vin);
    }

    /**
     * Retrieves the sales contract with the specified ID.
     *
     * @param id The ID of the sales contract to retrieve.
     * @return The sales contract with the specified ID.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public SaleContract getContractById(@RequestParam String id) {
        return salesContractDao.getContractById(id);
    }


}
