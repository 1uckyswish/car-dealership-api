package com.pluralsight.dealership.controllers;

import com.pluralsight.dealership.dao.LeaseContractDao;
import com.pluralsight.dealership.models.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lease-contracts")
public class LeaseContractsController {

    private LeaseContractDao leaseContractDao;

    @Autowired
    public LeaseContractsController(LeaseContractDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<LeaseContract> getAllContracts() {
        return leaseContractDao.getAllContracts();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addContract(@RequestParam String vin) {
        leaseContractDao.addContract(vin);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public LeaseContract getContractById(@RequestParam String id) {
        return leaseContractDao.getContractById(id);
    }


}
