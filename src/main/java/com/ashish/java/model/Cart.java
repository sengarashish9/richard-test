package com.ashish.java.model;

import com.ashish.java.exception.InvalidQuantityException;
import com.ashish.java.exception.NoProductExistException;
import com.ashish.java.factory.ProductFactory;
import com.ashish.java.service.DiscountService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 * Cart represents a singleton implementation which provided behaviours to calculate checkout price
 */
public class Cart {

    private static Cart cart;
    private Cart(){

    }
    private DiscountService discountService;

    /***
     *
     * @return Singleton instance of Cart
     */
    public static Cart getInstance(){
        if(cart==null){
            cart= new Cart();
        }
        return cart;
    }

    /***
     *
     * @param products Array of String Products
     * @return final checkout price
     */

    public BigDecimal checkOutPrice(String [] products) throws NoProductExistException, InvalidQuantityException {
        ProductFactory productFactory= new ProductFactory();
        if(products==null){
            return BigDecimal.ZERO;
        }
        Map<Product, BigDecimal> productCount= Arrays.stream(products).map(s -> productFactory.getProduct(s))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.collectingAndThen(Collectors.counting(), BigDecimal::valueOf)));
        discountService= new DiscountService();
        discountService.calculateProductsAfterDiscount(productCount);
        return productCount.entrySet().stream().map(productBigDecimalEntry ->
                        productBigDecimalEntry.getKey().getPrice().multiply(productBigDecimalEntry.getValue()))
                .reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element));
    }
}
