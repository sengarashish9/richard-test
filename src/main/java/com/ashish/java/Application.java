package com.ashish.java;

import com.ashish.java.model.Cart;


public class Application {

    public static void main(String[] args) {
        String products[] = {"Apple", "Apple", "Melons", "Melons",
                "Melons", "Limes", "Limes", "Limes", "Limes", "Limes"};
        System.out.println(Cart.getInstance().checkOutPrice(products));

    }

}
// remove imports
// extra dependency