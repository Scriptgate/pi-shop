package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.Product;
import net.scriptgate.pi.shop.controller.model.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return Products.all();
    }

    @GetMapping("/products/{id}")
    public Product getLocationById(@PathVariable("id") int id) {
        return Products.byId(id);
    }
}
