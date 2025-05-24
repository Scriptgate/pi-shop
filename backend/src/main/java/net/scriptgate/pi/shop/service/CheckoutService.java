package net.scriptgate.pi.shop.service;

import net.scriptgate.pi.shop.controller.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {

    private final List<Product> shoppingCart = new ArrayList<>();

    public void add(Product product) {
        shoppingCart.add(product);
    }

    public List<Product> getProducts() {
        return shoppingCart;
    }
}
