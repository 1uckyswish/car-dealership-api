package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.Vehicle;

import java.util.List;

/**
 * The VehicleDao interface defines methods for accessing and managing vehicle data.
 */
public interface VehicleDao {

    /**
     * Retrieves a list of all vehicles.
     *
     * @return A list of vehicles.
     */
    List<Vehicle> getAllVehicles();

    /**
     * Retrieves a list of vehicles within the specified price range.
     *
     * @param minPrice The minimum price.
     * @param maxPrice The maximum price.
     * @return A list of vehicles within the specified price range.
     */
    List<Vehicle> getByPrice(double minPrice, double maxPrice);

    /**
     * Retrieves a list of vehicles by make and model.
     *
     * @param make  The make of the vehicle.
     * @param model The model of the vehicle.
     * @return A list of vehicles matching the specified make and model.
     */
    List<Vehicle> getByMakeModel(String make, String model);

    /**
     * Retrieves a list of vehicles within the specified year range.
     *
     * @param minYear The minimum year.
     * @param maxYear The maximum year.
     * @return A list of vehicles within the specified year range.
     */
    List<Vehicle> getByYear(int minYear, int maxYear);

    /**
     * Retrieves a list of vehicles within the specified mileage range.
     *
     * @param minMileage The minimum mileage.
     * @param maxMileage The maximum mileage.
     * @return A list of vehicles within the specified mileage range.
     */
    List<Vehicle> getByMileage(int minMileage, int maxMileage);

    /**
     * Retrieves a list of vehicles by color.
     *
     * @param color The color of the vehicle.
     * @return A list of vehicles matching the specified color.
     */
    List<Vehicle> getByColor(String color);

    /**
     * Retrieves a list of vehicles by type.
     *
     * @param type The type of the vehicle (e.g., sedan, SUV).
     * @return A list of vehicles matching the specified type.
     */
    List<Vehicle> getByType(String type);

    /**
     * Adds a new vehicle to the data store.
     *
     * @param vehicle The vehicle to add.
     * @return The added vehicle.
     */
    Vehicle addVehicle(Vehicle vehicle);

    /**
     * Updates an existing vehicle in the data store.
     *
     * @param vin     The VIN (Vehicle Identification Number) of the vehicle to update.
     * @param vehicle The updated vehicle object.
     * @return The updated vehicle.
     */
    Vehicle updateVehicle(String vin, Vehicle vehicle);

    /**
     * Deletes a vehicle from the data store.
     *
     * @param vin The VIN (Vehicle Identification Number) of the vehicle to delete.
     */
    void deleteVehicle(String vin);
}
