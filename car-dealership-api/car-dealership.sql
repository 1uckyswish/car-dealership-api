-- Drop the database if it exists to ensure a clean slate
DROP DATABASE IF EXISTS dealership;

-- Create the dealership database if it doesn't exist and switch to it
CREATE DATABASE IF NOT EXISTS dealership;
USE dealership;

-- Create the 'dealerships' table to store information about car dealerships
CREATE TABLE `dealerships` (
    `dealership_id` INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each dealership
    `name` VARCHAR(100),   -- Name of the dealership
    `address` VARCHAR(100), -- Address of the dealership
    `phone` VARCHAR(20)     -- Phone number of the dealership
);

-- Create the 'vehicle' table to store information about vehicles
CREATE TABLE `vehicle` (
    `vin` INT PRIMARY KEY, -- Vehicle Identification Number (VIN), unique identifier for each vehicle
    `year` INT,            -- Year of manufacture
    `make` VARCHAR(50),    -- Make of the vehicle (e.g., Toyota, Honda)
    `model` VARCHAR(50),   -- Model of the vehicle (e.g., Camry, Civic)
    `type` VARCHAR(50),    -- Type of the vehicle (e.g., Sedan, Truck)
    `color` VARCHAR(50),   -- Color of the vehicle
    `odometer` INT,        -- Odometer reading (mileage) of the vehicle
    `price` DOUBLE,        -- Price of the vehicle
    `sold` VARCHAR(3)      -- Indicates whether the vehicle is sold or not (e.g., 'Yes', 'No')
);

-- Create the 'inventory' table to track which vehicles are available at which dealerships
CREATE TABLE `inventory` (
    `dealership_id` INT, -- Foreign key referencing 'dealerships' table
    `vin` INT UNIQUE,           -- Foreign key referencing 'vehicle' table
    PRIMARY KEY (`dealership_id`, `vin`), -- Composite primary key
    FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`), -- Foreign key constraint
    FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`) -- Foreign key constraint
);

-- Create the 'sales_contracts' table to store information about vehicle sales contracts
CREATE TABLE `sales_contracts` (
    `sales_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each sales contract
    `vin` INT UNIQUE,                                          -- Foreign key referencing 'vehicle' table
    FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)    -- Foreign key constraint
);

-- Create the 'lease_contracts' table to store information about vehicle lease contracts
CREATE TABLE `lease_contracts` (
    `lease_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each lease contract
    `vin` INT UNIQUE,                                          -- Foreign key referencing 'vehicle' table
    FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)    -- Foreign key constraint
);

-- Insert sample data into the 'dealerships' table
INSERT INTO `dealerships`(`name`, `address`, `phone`)
VALUES
    ('Hippo Motors', '123 Hippo Ave, Hippo City, HP1234', '555-HIPPO-1234'),
    ('Piggy Motors','456 Piggy Lane, Piglet Town, PG5678','555-OINK-5678'),
    ('Gator Motors','789 Swamp Road, Gatorville, GA9012','555-SNAP-9012'),
    ('Turtle Motors', '789 Shell Street, Turtle Bay, TB3456', '555-SLOW-7890'),
    ('Rabbit Motors', '101 Carrot Avenue, Bunny Town, BT6789', '555-HOP-1010'),
    ('Eagle Motors', '456 Talon Road, Eagle Peak, EP0123', '555-FLY-4567'),
    ('Bear Motors', '321 Den Cave, Bearsville, BS7890', '555-GRIZZLY-3210'),
    ('Wolf Motors', '555 Howl Lane, Wolfville, WV2345', '555-WOLF-5555');

-- Insert sample data into the 'vehicle' table
INSERT INTO `vehicle`(`vin`, `year`, `make`, `model`, `type`, `color`, `odometer`, `price`, `sold`)
VALUES
    (123456, 2022, 'Toyota', 'Camry', 'Sedan', 'Blue', 5000, 25000, 'No'),
    (234567, 2021, 'Honda', 'Civic', 'Sedan', 'Red', 8000, 22000, 'No'),
    (345678, 2020, 'Ford', 'F-150', 'Truck', 'Black', 10000, 35000, 'Yes'),
    (456789, 2023, 'Tesla', 'Model Y', 'SUV', 'White', 2000, 60000, 'No'),
    (567890, 2022, 'Lamborghini', 'Aventador', 'Sports Car', 'Yellow', 100, 300000, 'No'),
    (678901, 2021, 'Porsche', '911', 'Coupe', 'Black', 5000, 100000, 'Yes'),
    (789012, 2022, 'Chevrolet', 'Silverado', 'Truck', 'Silver', 12000, 40000, 'No'),
    (890123, 2023, 'BMW', 'X5', 'SUV', 'Black', 3000, 65000, 'No'),
    (901234, 2024, 'Mercedes-Benz', 'E-Class', 'Sedan', 'Gray', 500, 70000, 'No'),
    (123045, 2022, 'Audi', 'A4', 'Sedan', 'White', 2000, 55000, 'No'),
    (234056, 2023, 'Subaru', 'Outback', 'SUV', 'Green', 1000, 35000, 'No'),
    (345067, 2021, 'Mazda', 'CX-5', 'SUV', 'Blue', 7000, 30000, 'Yes'),
    (456078, 2022, 'Nissan', 'Altima', 'Sedan', 'Silver', 4000, 28000, 'No'),
    (567089, 2020, 'Jeep', 'Wrangler', 'SUV', 'Red', 15000, 45000, 'No'),
    (678090, 2023, 'Volvo', 'XC90', 'SUV', 'Black', 1500, 60000, 'No'),
    (789001, 2024, 'Ford', 'Explorer', 'SUV', 'White', 200, 55000, 'No'),
    (890112, 2021, 'Toyota', 'Rav4', 'SUV', 'Black', 8000, 32000, 'Yes'),
    (901223, 2022, 'Honda', 'Accord', 'Sedan', 'Blue', 3000, 30000, 'No'),
    (123334, 2023, 'Hyundai', 'Tucson', 'SUV', 'Silver', 2500, 35000, 'No'),
    (234445, 2020, 'Kia', 'Soul', 'Hatchback', 'Red', 12000, 25000, 'Yes'),
    (345556, 2024, 'GMC', 'Sierra', 'Truck', 'Black', 100, 50000, 'No'),
    (456667, 2023, 'Ram', '1500', 'Truck', 'Blue', 1000, 45000, 'No'),
    (567778, 2021, 'Volkswagen', 'Tiguan', 'SUV', 'Gray', 6000, 34000, 'No'),
    (678889, 2022, 'Buick', 'Encore', 'SUV', 'White', 4000, 38000, 'No'),
    (789990, 2020, 'Lexus', 'RX', 'SUV', 'Silver', 11000, 50000, 'Yes'),
    (890001, 2021, 'Infiniti', 'QX60', 'SUV', 'Black', 7000, 45000, 'No');

-- Insert sample data into the 'inventory' table to track vehicle availability at dealerships
INSERT INTO `inventory`(`dealership_id`, `vin`)
VALUES
    (1, 123456),
    (1, 234567),
    (1, 890112),
	(1, 901223),
    (1, 345556),
    (1, 456667),
    (1, 890001),
    (2, 567778),
    (2, 678889),
    (2, 789990),
    (2, 345678),
    (2, 456789),
    (2, 123334),
	(2, 234445),
    (3, 567890),
    (3, 678901),
    (4, 789012),
    (4, 890123),
    (5, 901234),
    (5, 123045),
    (6,234056),
	(6,345067),
	(7,456078),
	(7,567089),
	(8,678090),
	(8,789001);

-- Insert sample data into the 'sales_contracts' table to record vehicle sales
INSERT INTO `sales_contracts`(`vin`)
VALUES
    (345678),
    (678901),
    (345067),
    (890112),
    (234445),
    (789990);

INSERT INTO `lease_contracts`(`vin`)
VALUES
    (890001),
    (678889),
    (567778),
    (456667);
