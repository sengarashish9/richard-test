package com.ashish.java.discounting.strategy;

import com.ashish.java.exception.InvalidQuantityException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/***
 * Represents an interface to calculate quantity post applying discount
 */
public interface DiscountingMechanism {
    /***
     *
     * @param quantity quantity which user has gone for
     * @return new quantity after running the discounting mechanism
     * @throws InvalidQuantityException
     */
    BigDecimal applyDiscount(BigDecimal quantity) throws InvalidQuantityException;

    default boolean validateQuantityBeforeDiscounting(BigDecimal quantity){
        String biStr = quantity.toBigInteger().toString();
        String bdStr = quantity.setScale(0, RoundingMode.UP).toString();
        return biStr.equals(bdStr);
    }

}
