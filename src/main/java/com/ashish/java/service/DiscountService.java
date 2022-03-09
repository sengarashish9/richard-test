package com.ashish.java.service;

import com.ashish.java.model.Product;

import java.math.BigDecimal;
import java.util.Map;

/***
 * DiscountService is used to calculate quantities of each product post applying offer
 */
public class DiscountService {

    /***
     *
     * @param products accepts products and respective count before applying offer
     *                 updates quantity in-place post applying offers for each product
     */
    public void calculateProductsAfterDiscount(Map<Product, BigDecimal> products) {
        products.entrySet().stream()
                .filter(productBigDecimalEntry -> productBigDecimalEntry.getKey().getDiscountType() != null).
                forEach(productLongEntry -> productLongEntry.setValue(productLongEntry.getKey()
                        .getDiscountType().getDiscount().applyDiscount(productLongEntry.getValue())));
    }
}
