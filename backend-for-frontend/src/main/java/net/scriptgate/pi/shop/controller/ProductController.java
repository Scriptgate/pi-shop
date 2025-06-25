package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.ProductDTO;
import net.scriptgate.pi.shop.controller.model.ProductDTOMapper;
import net.scriptgate.pi.shop.ports.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/backend")
public class ProductController {

    @Autowired private ProductRepository productRepository;

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productRepository.list().stream().map(ProductDTOMapper::map).toList();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getLocationById(@PathVariable("id") long id) {
        return productRepository.find(id).map(ProductDTOMapper::map).orElse(null);
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
                productRepository.save(name, image.getBytes(), type, barcode, price)
        );
    }
}
