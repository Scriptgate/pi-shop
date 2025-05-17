package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.Product;
import net.scriptgate.pi.shop.controller.model.ProductBuilder;
import net.scriptgate.pi.shop.controller.model.Products;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/products/create")
    public Product create(
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile image,
            @RequestParam("type") String type,
            @RequestParam("price") String price
    ) throws IOException {
        return Products.create(
                ProductBuilder.product(0, name)
                        .image(image.getBytes())
                        .type(type)
                        .price(Double.parseDouble(price))
                        .build()
        );
    }
}
