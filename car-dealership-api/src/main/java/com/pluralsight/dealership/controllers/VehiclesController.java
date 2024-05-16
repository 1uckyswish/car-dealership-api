package com.pluralsight.dealership.controllers;


import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The VehiclesController class handles HTTP requests related to vehicles.
 */
@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleDao vehicleDao;

    /**
     * Retrieves a list of all vehicles.
     *
     * @return A list of all vehicles.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    /**
     * Retrieves a list of vehicles within the specified price range.
     *
     * @param minPrice The minimum price.
     * @param maxPrice The maximum price.
     * @return A list of vehicles within the specified price range.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"minPrice", "maxPrice"})
    public List<Vehicle> getByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice) {
        return vehicleDao.getByPrice(minPrice, maxPrice);
    }

    /**
     * Retrieves a list of vehicles by make and model.
     *
     * @param make  The make of the vehicle.
     * @param model The model of the vehicle.
     * @return A list of vehicles with the specified make and model.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"make", "model"})
    public List<Vehicle> getByMakeModel(@RequestParam("make") String make, @RequestParam("model") String model) {
        return vehicleDao.getByMakeModel(make, model);
    }

    /**
     * Retrieves a list of vehicles within the specified year range.
     *
     * @param minYear The minimum year.
     * @param maxYear The maximum year.
     * @return A list of vehicles within the specified year range.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"minYear", "maxYear"})
    public List<Vehicle> getByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        return vehicleDao.getByYear(minYear, maxYear);
    }

    /**
     * Retrieves a list of vehicles within the specified mileage range.
     *
     * @param minMileage The minimum mileage.
     * @param maxMileage The maximum mileage.
     * @return A list of vehicles within the specified mileage range.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"minMileage", "maxMileage"})
    public List<Vehicle> getByMileage(@RequestParam("minMileage") int minMileage, @RequestParam("maxMileage") int maxMileage) {
        return vehicleDao.getByMileage(minMileage, maxMileage);
    }

    /**
     * Retrieves a list of vehicles with the specified color.
     *
     * @param color The color of the vehicle.
     * @return A list of vehicles with the specified color.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"color"})
    public List<Vehicle> getByColor(@RequestParam("color") String color) {
        return vehicleDao.getByColor(color);
    }

    /**
     * Retrieves a list of vehicles with the specified type.
     *
     * @param type The type of the vehicle.
     * @return A list of vehicles with the specified type.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"type"})
    public List<Vehicle> getByType(@RequestParam("type") String type) {
        return vehicleDao.getByType(type);
    }

    /**
     * Adds a new vehicle to the system.
     *
     * @param vehicle The vehicle object to add.
     * @return The added vehicle.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleDao.addVehicle(vehicle);
        return newVehicle;
    }

    /**
     * Updates an existing vehicle.
     *
     * @param vin     The VIN (Vehicle Identification Number) of the vehicle to update.
     * @param vehicle The updated vehicle object.
     * @return The updated vehicle.
     */
    @RequestMapping(method = RequestMethod.PUT, params = {"vin"})
    @ResponseStatus(value = HttpStatus.OK)
    public Vehicle updateVehicle(@RequestParam("vin") String vin, @RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleDao.updateVehicle(vin, vehicle);
        return newVehicle;
    }

    /**
     * Deletes a vehicle from the system.
     *
     * @param vin The VIN of the vehicle to delete.
     */
    @RequestMapping(method = RequestMethod.DELETE, params = {"vin"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@RequestParam("vin") String vin) {
        vehicleDao.deleteVehicle(vin);
    }

}
