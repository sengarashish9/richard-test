package com.ashish.java.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
class CartTest {

    Cart cart;
    String [] products=null;

    @BeforeEach
    void setUp() {
        cart=Cart.getInstance();

    }

    @AfterEach
    void tearDown() {
        cart=null;
    }

    @Test
    void checkOutPriceWithEmptyBasket() {
        Assertions.assertEquals(cart.checkOutPrice(products), BigDecimal.ZERO);
    }

    @Test
    void checkOutPriceWithBasket() {
        products= new String[]{"Apple", "Apple", "Melons", "Melons", "Melons", "Limes", "Limes", "Limes", "Limes", "Limes"};
        Assertions.assertEquals(cart.checkOutPrice(products), BigDecimal.valueOf(2.3).setScale(3, RoundingMode.HALF_UP));
    }
}