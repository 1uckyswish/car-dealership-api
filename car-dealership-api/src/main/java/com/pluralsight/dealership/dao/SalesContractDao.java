package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.SaleContract;

import java.util.List;

public interface SalesContractDao {
    SaleContract getContractById(String id);
    List<SaleContract> getAllContracts();
    void addContract(String vin);
}
