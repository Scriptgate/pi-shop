package net.scriptgate.pi.shop.services;

import net.scriptgate.pi.shop.models.Product;
import net.scriptgate.pi.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Optional<Product> find(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> find(String barcode) {
        return productRepository.findByBarcode(barcode).stream().findAny();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
