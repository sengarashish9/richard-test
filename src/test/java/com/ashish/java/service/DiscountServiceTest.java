package com.ashish.java.service;

import com.ashish.java.DiscountType;
import com.ashish.java.exception.NoProductExistException;
import com.ashish.java.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    DiscountService discountService;
    Map<Product, BigDecimal> products;
    @BeforeEach
    void setUp() {
        products= new HashMap<>();
        discountService= new DiscountService();
    }
    @Test
    void testDiscountService() {
        Product apple=new Product("Apple",BigDecimal.valueOf(.35));
        Product melons=new Product("Melons",BigDecimal.valueOf(.50), DiscountType.ONE_FOR_ONE);
        Product limes=new Product("Limes",BigDecimal.valueOf(.15), DiscountType.THREE_FOR_TWO);
        products.put(apple,BigDecimal.valueOf(4));
        products.put(melons,BigDecimal.valueOf(5));
        products.put(limes,BigDecimal.valueOf(4));
        discountService.calculateProductsAfterDiscount(products);
        Assertions.assertEquals(products.get(apple),BigDecimal.valueOf(4));
        Assertions.assertEquals(products.get(melons),BigDecimal.valueOf(3));
        Assertions.assertEquals(products.get(limes),BigDecimal.valueOf(3));
    }


    @AfterEach
    void tearDown() {
        products=null;
        discountService=null;

    }
}