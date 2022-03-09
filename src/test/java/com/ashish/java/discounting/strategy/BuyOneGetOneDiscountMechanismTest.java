package com.ashish.java.discounting.strategy;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BuyOneGetOneDiscountMechanismTest {

    static BuyOneGetOneDiscountMechanism buyOneGetOneDiscountMechanism;

    @BeforeAll
    static void setupThis(){
        buyOneGetOneDiscountMechanism= new BuyOneGetOneDiscountMechanism();
    }
    @Test
    void applyDiscountForZeroQuantity(){
        Assertions.assertEquals(buyOneGetOneDiscountMechanism.applyDiscount(BigDecimal.ZERO),BigDecimal.ZERO);
        Assertions.assertEquals(buyOneGetOneDiscountMechanism.applyDiscount(BigDecimal.valueOf(100)),BigDecimal.valueOf(50));
        Assertions.assertEquals(buyOneGetOneDiscountMechanism.applyDiscount(BigDecimal.valueOf(101)),BigDecimal.valueOf(51));
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
}