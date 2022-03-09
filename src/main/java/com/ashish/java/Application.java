package com.ashish.java;

import com.ashish.java.model.Cart;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


public class Application {

    public static void main(String[] args) {
        String products[] = {"Apple", "Apple", "Melons", "Melons", "Melons", "Limes", "Limes", "Limes", "Limes", "Limes"};
        System.out.println(Cart.getInstance().checkOutPrice(products));

    }

}
