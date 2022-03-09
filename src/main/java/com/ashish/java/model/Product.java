package com.ashish.java.model;

import com.ashish.java.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;
    private DiscountType discountType;

    public Product(String name, BigDecimal price){
        this(name,price,null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
               /// ", price=" + price +
        // ", discountType=" + discountType +
                '}';
    }
}
