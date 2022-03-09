package com.ashish.java.exception;
/**
 * The NoProductExistException is used to validate if a passed product doesn't exist in inventory.
 * You can use InvalidQuantityException to validate the incorrect quantity for product.
 *
 * @author Ashish
 */
public class NoProductExistException extends RuntimeException {

    public NoProductExistException(String errorMessage) {
        super(errorMessage);
    }
}
