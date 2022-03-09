package com.ashish.java.enums;

import com.ashish.java.discounting.strategy.BuyOneGetOneDiscountMechanism;
import com.ashish.java.discounting.strategy.DiscountingMechanism;
import com.ashish.java.discounting.strategy.ThreeForTwoDiscountingMechanism;

/***
 * DiscountType restricts the user to define only allowed discount mechanism, can be implemented using some rule engine
 */
public enum DiscountType {
    ONE_FOR_ONE(new BuyOneGetOneDiscountMechanism()),
    THREE_FOR_TWO(new ThreeForTwoDiscountingMechanism());

    private final DiscountingMechanism discountingMechanism;

    public DiscountingMechanism getDiscount() {
        return discountingMechanism;
    }

    DiscountType(DiscountingMechanism discountingMechanism) {
        this.discountingMechanism = discountingMechanism;
    }
}
