package com.pluralsight.dealership.utilityMethods;

import com.pluralsight.dealership.models.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The VehicleUtils class provides utility methods for handling Vehicle objects.
 */
public class VehicleUtils {

    /**
     * Converts a ResultSet object into a Vehicle object.
     *
     * @param resultSet The ResultSet object containing data representing a vehicle.
     * @return A Vehicle object created from the data in the ResultSet.
     * @throws SQLException If an SQL exception occurs while accessing data from the ResultSet.
     */
    public static Vehicle resultSetToVehicle(ResultSet resultSet) throws SQLException {
        String vin = resultSet.getString(1);
        int year = resultSet.getInt(2);
        String make = resultSet.getString(3);
        String model = resultSet.getString(4);
        String type = resultSet.getString(5);
        String color = resultSet.getString(6);
        int odometer = resultSet.getInt(7);
        double price = resultSet.getDouble(8);
        String sold = resultSet.getString(9);

        return new Vehicle(vin, year, make, model, type, color, odometer, price, sold);
    }
}
