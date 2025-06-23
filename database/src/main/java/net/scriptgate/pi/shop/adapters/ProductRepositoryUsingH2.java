package net.scriptgate.pi.shop.adapters;

import net.scriptgate.pi.shop.domain.Product;
import net.scriptgate.pi.shop.ports.ProductRepository;
import net.scriptgate.pi.shop.repositories.DatabaseProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static net.scriptgate.pi.shop.models.DatabaseProductBuilder.product;

@Service
public class ProductRepositoryUsingH2 implements ProductRepository {

    private final DatabaseProductRepository databaseProductRepository;

    public ProductRepositoryUsingH2(DatabaseProductRepository databaseProductRepository) {
        this.databaseProductRepository = databaseProductRepository;
    }

    @Override
    public List<? extends Product> list() {
        return databaseProductRepository.findAll();
    }

    @Override
    public Optional<? extends Product> find(Long id) {
        return databaseProductRepository.findById(id);
    }

    @Override
    public Optional<? extends Product> find(String barcode) {
        return databaseProductRepository.findByBarcode(barcode).stream().findAny();
    }

    @Override
    public Product save(String name, String image, String type, String barcode, double price) {
        return databaseProductRepository.save(product(name)
                .image(image)
                .type(type)
                .barcode(barcode)
                .price(price)
                .build()
        );
    }
}
