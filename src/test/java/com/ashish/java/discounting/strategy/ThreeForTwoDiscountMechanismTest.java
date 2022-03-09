package com.ashish.java.discounting.strategy;

import com.ashish.java.DiscountType;
import com.ashish.java.exception.InvalidQuantityException;
import com.ashish.java.exception.NoProductExistException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ThreeForTwoDiscountMechanismTest {

    static ThreeForTwoDiscountingMechanism threeForTwoDiscountingMechanism;

    @BeforeAll
    static void setupThis(){
        threeForTwoDiscountingMechanism= new ThreeForTwoDiscountingMechanism();
    }
    @Test
    void applyDiscountForZeroQuantity(){
        Assertions.assertEquals(threeForTwoDiscountingMechanism.applyDiscount(BigDecimal.ZERO),BigDecimal.ZERO);
        Assertions.assertEquals(threeForTwoDiscountingMechanism.applyDiscount(BigDecimal.valueOf(3)),BigDecimal.valueOf(2));
        Assertions.assertEquals(threeForTwoDiscountingMechanism.applyDiscount(BigDecimal.valueOf(4)),BigDecimal.valueOf(3));
    }

    @Test
    void applyDiscountForInvalidQuantity(){
        Assertions.assertThrows(InvalidQuantityException.class, () -> {
            threeForTwoDiscountingMechanism.applyDiscount(BigDecimal.valueOf(1.3));
        });
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
}