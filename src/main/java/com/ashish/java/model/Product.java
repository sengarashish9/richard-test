package com.ashish.java.model;

import com.ashish.java.enums.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 */
@Data
@AllArgsConstructor
@ToString
public class Product {
    private String name;
    private BigDecimal price;
    private DiscountType discountType;

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


}
