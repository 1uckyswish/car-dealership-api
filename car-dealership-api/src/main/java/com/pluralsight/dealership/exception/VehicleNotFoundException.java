package com.pluralsight.dealership.exception;

/**
 * The VehicleNotFoundException class represents an exception thrown when a vehicle is not found.
 * It extends the RuntimeException class.
 */
public class VehicleNotFoundException extends RuntimeException {

    /**
     * Constructs a new VehicleNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
