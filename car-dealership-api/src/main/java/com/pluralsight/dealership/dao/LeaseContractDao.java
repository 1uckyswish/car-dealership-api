package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.LeaseContract;

import java.util.List;

public interface LeaseContractDao {
    LeaseContract getContractById(String id);
    List<LeaseContract> getAllContracts();
    void addContract(String vin);
}
