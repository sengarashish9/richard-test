package com.ashish.java.exception;

/**
 * The InvalidQuantityException is used to validate quantity check for a product.
 * You can use InvalidQuantityException to validate the incorrect quantity for product.
 *
 */
public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String errorMessage) {
        super(errorMessage);
    }
}
