package net.scriptgate.pi.shop.repositories;

import net.scriptgate.pi.shop.models.DatabaseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseProductRepository extends JpaRepository<DatabaseProduct, Long> {

    List<DatabaseProduct> findByBarcode(String barcode);

}
