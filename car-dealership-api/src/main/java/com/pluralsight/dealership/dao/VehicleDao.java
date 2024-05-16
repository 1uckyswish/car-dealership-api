package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> getAllVehicles();
    List<Vehicle> getByPrice(double minPrice, double maxPrice);
    List<Vehicle> getByMakeModel(String make, String model);
    List<Vehicle> getByYear(int minYear, int maxYear);
    List<Vehicle> getByMileage(int minMileage, int maxMileage);
    List<Vehicle> getByColor(String color);
    List<Vehicle> getByType(String type);
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(String vin,Vehicle vehicle);
    void deleteVehicle(String vin);
}
