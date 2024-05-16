package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.LeaseContract;
import com.pluralsight.dealership.models.SaleContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JbdcLeaseContractDao implements LeaseContractDao{

    private DataSource dataSource;

    @Autowired
    public JbdcLeaseContractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public LeaseContract getContractById(String id) {
        String query = "SELECT * FROM lease_contracts WHERE lease_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    return new LeaseContract(resultSet.getString("lease_id"), resultSet.getString("vin"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log an error or return an appropriate message if no contract with the given ID is found
        System.err.println("Error: Failed to fetch lease contract with ID " + id);
        return null;
    }

    @Override
    public List<LeaseContract> getAllContracts() {
        String query = "SELECT * FROM lease_contracts";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<LeaseContract> contracts = new ArrayList<>();
                while (resultSet.next()) {
                    contracts.add(new LeaseContract(resultSet.getString("lease_id"), resultSet.getString("vin")));
                }
                return contracts;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log an error or return an appropriate message if no contracts are found
        System.err.println("Error: Failed to fetch all lease contracts.");
        return new ArrayList<>(); // Return an empty list as fallback
    }

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

            // Update the vehicle table to mark the car as leased
            String updateSql = "UPDATE vehicle SET sold = 'No' WHERE vin = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setString(1, vin);
                int updateRowsAffected = updateStatement.executeUpdate();
                if (updateRowsAffected == 1) {
                    System.out.println("Vehicle leased successfully.");
                } else {
                    System.err.println("Error: Failed to lease vehicle. Vehicle with VIN " + vin + " not found.");
                    return;
                }
            }

            // Insert the VIN into the lease_contract table
            String insertSql = "INSERT INTO lease_contracts (vin) VALUES (?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                insertStatement.setString(1, vin);
                int insertRowsAffected = insertStatement.executeUpdate();
                if (insertRowsAffected == 1) {
                    System.out.println("Vehicle VIN inserted into lease contract successfully.");
                } else {
                    System.err.println("Error: Failed to insert vehicle VIN into lease contract.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error adding lease contract: " + e.getMessage());
        }
        System.err.println("Error: Failed to insert vehicle VIN into lease contract.");
    }

}
