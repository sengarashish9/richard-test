package com.ashish.java.factory;

import com.ashish.java.DiscountType;
import com.ashish.java.exception.NoProductExistException;
import com.ashish.java.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    ProductFactory productFactory;
    @BeforeEach
    void setUp() {
        productFactory= new ProductFactory();
    }

    @AfterEach
    void tearDown() {
        productFactory= null;
    }

    @Test
    void testGetAppleProduct() {
        Product appleProduct= productFactory.getProduct("Apple");
        Assertions.assertEquals(appleProduct.getPrice(), BigDecimal.valueOf(.35).setScale(3, RoundingMode.HALF_UP));
        Assertions.assertEquals(appleProduct.getName(), "Apple");
        Assertions.assertNull(appleProduct.getDiscountType());
    }

    @Test
    void testGetBananaProduct() {
        Assertions.assertThrows(NoProductExistException.class, () -> {
            productFactory.getProduct("Banana");
        });
    }

    @Test
    void testGetMelonsProductStrategy() {
        Product appleProduct= productFactory.getProduct("Melons");
        Assertions.assertEquals(appleProduct.getDiscountType(), DiscountType.ONE_FOR_ONE);
    }
}