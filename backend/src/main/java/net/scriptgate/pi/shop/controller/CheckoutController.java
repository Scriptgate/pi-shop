package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.Product;
import net.scriptgate.pi.shop.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/checkout")
    public List<Product> getProducts() {
        return checkoutService.getProducts();
    }
}
