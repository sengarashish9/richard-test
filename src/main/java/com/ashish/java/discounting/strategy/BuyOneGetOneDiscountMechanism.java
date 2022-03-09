package com.ashish.java.discounting.strategy;

import com.ashish.java.exception.InvalidQuantityException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneGetOneDiscountMechanism implements DiscountingMechanism{
    /***
     *
     * @param quantity quantity which user has gone for
     * @return new quantity post running buy 1, get 1 free offer
     */
    @Override
    public BigDecimal applyDiscount(BigDecimal quantity) {
        if(!validateQuantityBeforeDiscounting(quantity)){
            throw new InvalidQuantityException("quantity is invalid "+quantity);
        }
        return quantity.divide(BigDecimal.valueOf(2), RoundingMode.CEILING);
    }
}
