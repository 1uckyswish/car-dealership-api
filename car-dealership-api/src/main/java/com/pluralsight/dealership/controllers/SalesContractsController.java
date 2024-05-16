package com.pluralsight.dealership.controllers;

import com.pluralsight.dealership.dao.SalesContractDao;
import com.pluralsight.dealership.models.SaleContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales-contracts")
public class SalesContractsController {

    private SalesContractDao salesContractDao;

    @Autowired
    public SalesContractsController(SalesContractDao salesContractDao) {
        this.salesContractDao = salesContractDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SaleContract> getAllContracts() {
        return salesContractDao.getAllContracts();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addContract(@RequestParam String vin) {
        salesContractDao.addContract(vin);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"id"})
    public SaleContract getContractById(@RequestParam String id) {
        return salesContractDao.getContractById(id);
    }


}
