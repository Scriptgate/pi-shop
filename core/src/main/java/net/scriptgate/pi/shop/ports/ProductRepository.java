package net.scriptgate.pi.shop.ports;

import net.scriptgate.pi.shop.domain.Product;
import net.scriptgate.pi.shop.util.ImageResizer;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<? extends Product> list();

    Optional<? extends Product> find(Long id);

    Optional<? extends Product> find(String barcode);

    default Product save(String name, byte[] image, String type, String barcode, String price) {
        return this.save(name, ImageResizer.resized(image), type, barcode, Double.parseDouble(price));
    }

    Product save(String name, String image, String type, String barcode, double price);
}
