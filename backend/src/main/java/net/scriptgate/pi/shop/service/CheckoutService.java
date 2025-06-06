package net.scriptgate.pi.shop.service;

import net.scriptgate.pi.shop.controller.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {

    @Autowired private SimpMessagingTemplate template;

    private final List<Product> shoppingCart = new ArrayList<>();

    public void add(Product product) {
        shoppingCart.add(product);
        template.convertAndSend("/checkout/products", getProducts());
    }

    public List<Product> getProducts() {
        return shoppingCart;
    }
}
