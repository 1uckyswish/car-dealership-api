package com.pluralsight.dealership.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * The DatabaseConfiguration class provides configuration for the database connection.
 */
@Configuration
public class DatabaseConfiguration {

    @Value("${connectionUrl}")
    private String connectionUrl;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    /**
     * Creates and configures the data source for the database connection.
     *
     * @return The configured DataSource object.
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(connectionUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
