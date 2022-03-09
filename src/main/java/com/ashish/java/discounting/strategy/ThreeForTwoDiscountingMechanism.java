package com.ashish.java.discounting.strategy;

import com.ashish.java.exception.InvalidQuantityException;

import java.math.BigDecimal;


public class ThreeForTwoDiscountingMechanism implements  DiscountingMechanism{
    /***
     *
     * @param quantity quantity which user has gone for
     * @return new quantity post running buy 3, on 2 price offer
     */
    @Override
    public BigDecimal applyDiscount(BigDecimal quantity) {
        if(!validateQuantityBeforeDiscounting(quantity)){
            throw new InvalidQuantityException("quantity is invalid "+quantity);
        }
        BigDecimal[] res=quantity.divideAndRemainder(BigDecimal.valueOf(3));
        return (res[0].multiply(BigDecimal.valueOf(2))).add(res[1]);
    }
}
