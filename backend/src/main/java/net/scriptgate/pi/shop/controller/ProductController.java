package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.ProductDTOMapper;
import net.scriptgate.pi.shop.controller.model.ProductDTO;
import net.scriptgate.pi.shop.services.ProductService;
import net.scriptgate.pi.shop.util.ImageResizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static net.scriptgate.pi.shop.models.ProductBuilder.product;

@RestController
@RequestMapping("/backend")
public class ProductController {

    @Autowired private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productService.list().stream().map(ProductDTOMapper::map).toList();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getLocationById(@PathVariable("id") long id) {
        return productService.find(id).map(ProductDTOMapper::map).orElse(null);
    }

    @PostMapping("/products/create")
    public ProductDTO create(
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile image,
            @RequestParam("type") String type,
            @RequestParam("barcode") String barcode,
            @RequestParam("price") String price
    ) throws IOException {
        return ProductDTOMapper.map(
                productService.save(
                        product(name)
                                .image(ImageResizer.resized(image.getBytes()))
                                .type(type)
                                .barcode(barcode)
                                .price(Double.parseDouble(price))
                                .build()
                )
        );
    }
}
