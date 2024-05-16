package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.Contract;
import com.pluralsight.dealership.models.SaleContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * The JbdcSalesContractDao class implements the SalesContractDao interface
 * using JDBC for data access.
 */
@Component
public class JbdcSalesContractDao implements SalesContractDao {

    private DataSource dataSource;

    /**
     * Constructs a new JbdcSalesContractDao object with the specified data source.
     *
     * @param dataSource The data source to use for database connection.
     */
    @Autowired
    public JbdcSalesContractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Retrieves a sales contract by its ID from the database.
     *
     * @param id The ID of the sales contract to retrieve.
     * @return The sales contract with the specified ID, or null if not found.
     */
    @Override
    public SaleContract getContractById(String id) {
        String query = "SELECT * FROM sales_contracts WHERE sales_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Assuming the SaleContract constructor takes the salesID and vehicleID
                    return new SaleContract(resultSet.getString("sales_id"), resultSet.getString("vin"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: Failed to fetch sales contract with ID " + id);
        }
        System.err.println("Error: Failed to fetch sales contract with ID " + id);
        return null;
    }

    /**
     * Retrieves a list of all sales contracts from the database.
     *
     * @return A list of all sales contracts.
     */
    @Override
    public List<SaleContract> getAllContracts() {

        String query = "SELECT * FROM sales_contracts";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<SaleContract> contracts = new ArrayList<>();
                while (resultSet.next()) {
                    contracts.add(new SaleContract(resultSet.getString("sales_id"), resultSet.getString("vin")));
                }
                return contracts;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: Failed to fetch all sales contracts.");
        }
        System.err.println("Error: Failed to fetch all sales contracts.");
        return null;
    }

    /**
     * Adds a new sales contract for the vehicle with the specified VIN to the
     * database.
     *
     * @param vin The VIN of the vehicle to add a sales contract for.
     */
    @Override
    public void addContract(String vin) {
        try (Connection connection = dataSource.getConnection()) {
            // Check if the VIN exists in the vehicle table
            String checkVinSql = "SELECT COUNT(*) FROM vehicle WHERE vin = ?";
            try (PreparedStatement checkVinStatement = connection.prepareStatement(checkVinSql)) {
                checkVinStatement.setString(1, vin);
                try (ResultSet resultSet = checkVinStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        if (count == 0) {
                            System.err.println("Error: Vehicle with VIN " + vin + " not found.");
                            return;
                        }
                    }
                }
            }

            // Update the vehicle table to mark the car as sold
            String updateSql = "UPDATE vehicle SET sold = 'Yes' WHERE vin = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setString(1, vin);
                int updateRowsAffected = updateStatement.executeUpdate();
                if (updateRowsAffected == 1) {
                    System.out.println("Vehicle Sold successfully.");
                } else {
                    System.err.println("Error: Failed to sell vehicle. Vehicle with VIN " + vin + " not found.");
                    return;
                }
            }

            // Insert the VIN into the sales_contract table
            String insertSql = "INSERT INTO sales_contracts (vin) VALUES (?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                insertStatement.setString(1, vin);
                int insertRowsAffected = insertStatement.executeUpdate();
                if (insertRowsAffected == 1) {
                    System.out.println("Vehicle VIN inserted into sales contract successfully.");
                } else {
                    System.err.println("Error: Failed to insert vehicle VIN into sales contract.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error adding contract: " + e.getMessage());
        }
    }

}
