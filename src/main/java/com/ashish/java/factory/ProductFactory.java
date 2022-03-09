package com.ashish.java.factory;

import com.ashish.java.enums.DiscountType;
import com.ashish.java.exception.NoProductExistException;
import com.ashish.java.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductFactory {

    /***
     *
     * @param name String name of the product
     * @return Product instance of a class which includes price and discounting mechanism
     */
    public Product getProduct(String name) throws NoProductExistException{
        if (name.equalsIgnoreCase("Apple")) {
            return new Product(name, new BigDecimal(.35).setScale(3, RoundingMode.HALF_UP),null);
        } else if (name.equalsIgnoreCase("Bananas")) {
            return new Product(name, new BigDecimal(.20).setScale(3, RoundingMode.HALF_UP),null);
        } else if (name.equalsIgnoreCase("Melons")) {
            return new Product(name, new BigDecimal(.50).setScale(3, RoundingMode.HALF_UP), DiscountType.ONE_FOR_ONE);
        } else if (name.equalsIgnoreCase("Limes")) {
            return new Product(name, new BigDecimal(.15).setScale(3, RoundingMode.HALF_UP), DiscountType.THREE_FOR_TWO);
        } else {
            throw new NoProductExistException("Product does not exist : " + name);
        }
    }
}
