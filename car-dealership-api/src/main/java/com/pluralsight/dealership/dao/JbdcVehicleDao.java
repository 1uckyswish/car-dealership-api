package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.exception.VehicleNotFoundException;
import com.pluralsight.dealership.models.Vehicle;
import com.pluralsight.dealership.utilityMethods.VehicleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JbdcVehicleDao implements VehicleDao{

    private DataSource dataSource;

    @Autowired
    public JbdcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }

        }catch (Exception e) {
            System.out.println("Error fetching vehicles: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByPrice(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE price BETWEEN ? AND ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }
        } catch (Exception e) {
            System.out.println("Error fetching vehicles by price: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE make = ? AND model = ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }
        } catch (Exception e) {
            System.out.println("Error fetching vehicles by make and model: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByYear(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE year BETWEEN ? AND ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, minYear);
            preparedStatement.setInt(2, maxYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }
        } catch (Exception e) {
            System.out.println("Error fetching vehicles by year range: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByMileage(int minMileage, int maxMileage) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE odometer BETWEEN ? AND ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, minMileage);
            preparedStatement.setInt(2, maxMileage);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }
        } catch (Exception e) {
            System.out.println("Error fetching vehicles by mileage range: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE color = ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, color);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }
        } catch (Exception e) {
            System.out.println("Error fetching vehicles by color: " + e.getMessage());
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sqlQuery = "SELECT * FROM vehicle WHERE type = ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vehicles.add(VehicleUtils.resultSetToVehicle(resultSet));
            }
        } catch (Exception e) {
            System.out.println("Error fetching vehicles by Type: " + e.getMessage());
        }
        return vehicles;
    }


    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        String sqlQuery = "INSERT INTO vehicle (vin, year, make, model, type, color, odometer, price, sold) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setInt(2, vehicle.getYear());
            preparedStatement.setString(3, vehicle.getMake());
            preparedStatement.setString(4, vehicle.getModel());
            preparedStatement.setString(5, vehicle.getType());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setInt(7, vehicle.getOdometer());
            preparedStatement.setDouble(8, vehicle.getPrice());
            preparedStatement.setString(9, vehicle.getSold());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
        }
        return vehicle;
    }

    @Override
    public Vehicle updateVehicle(String vin, Vehicle vehicle) {
        String sqlQuery = "UPDATE vehicle SET year = ?, make = ?, model = ?, type = ?, color = ?, odometer = ?, price = ?, sold = ? " +
                "WHERE vin = ?";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            // Check if the vehicle with the provided VIN exists in the database
            if (!vehicleExists(vin)) {
                throw new VehicleNotFoundException("Vehicle with VIN " + vin + " not found");
            }
            preparedStatement.setInt(1, vehicle.getYear());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setString(4, vehicle.getType());
            preparedStatement.setString(5, vehicle.getColor());
            preparedStatement.setInt(6, vehicle.getOdometer());
            preparedStatement.setDouble(7, vehicle.getPrice());
            preparedStatement.setString(8, vehicle.getSold());
            preparedStatement.setInt(9, Integer.parseInt(vin));
            preparedStatement.executeUpdate();
            // Set the vin property of the updated vehicle
            vehicle.setVin(vin);
        } catch (Exception e) {
            System.out.println("Error updating vehicle: " + e.getMessage());
        }
        return vehicle;
    }

    @Override
    public void deleteVehicle(String vin) {
        String sqlQuery = "DELETE FROM vehicle WHERE vin = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, vin);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error deleting vehicle: " + e.getMessage());
        }
    }

    private boolean vehicleExists(String vin) {
        String query = "SELECT COUNT(*) FROM vehicle WHERE vin = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, vin);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error checking if vehicle exists: " + e.getMessage());
        }
        return false;
    }
}
