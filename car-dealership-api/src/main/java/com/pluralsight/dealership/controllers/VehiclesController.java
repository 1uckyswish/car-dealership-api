package com.pluralsight.dealership.controllers;


import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleDao vehicleDao;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"minPrice", "maxPrice"})
    public List<Vehicle> getByPrice(@RequestParam("minPrice") double minPrice, @RequestParam("maxPrice") double maxPrice) {
        return vehicleDao.getByPrice(minPrice, maxPrice);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"make", "model"})
    public List<Vehicle> getByMakeModel(@RequestParam("make") String make, @RequestParam("model") String model) {
        return vehicleDao.getByMakeModel(make, model);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"minYear", "maxYear"})
    public List<Vehicle> getByYear(@RequestParam("minYear") int minYear, @RequestParam("maxYear") int maxYear) {
        return vehicleDao.getByYear(minYear, maxYear);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"minMileage", "maxMileage"})
    public List<Vehicle> getByMileage(@RequestParam("minMileage") int minMileage, @RequestParam("maxMileage") int maxMileage) {
        return vehicleDao.getByMileage(minMileage, maxMileage);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"color"})
    public List<Vehicle> getByColor(@RequestParam("color") String color) {
        return vehicleDao.getByColor(color);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"type"})
    public List<Vehicle> getByType(@RequestParam("type") String type) {
        return vehicleDao.getByType(type);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleDao.addVehicle(vehicle);
        return newVehicle;
    }

    @RequestMapping(method = RequestMethod.PUT, params = {"vin"})
    @ResponseStatus(value = HttpStatus.OK)
    public Vehicle updateVehicle(@RequestParam("vin") String vin, @RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleDao.updateVehicle(vin, vehicle);
        return newVehicle;
    }

    @RequestMapping(method = RequestMethod.DELETE, params = {"vin"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@RequestParam("vin") String vin) {
        vehicleDao.deleteVehicle(vin);
    }

}
