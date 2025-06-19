package net.scriptgate.pi.shop.repositories;

import net.scriptgate.pi.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBarcode(String barcode);

}
