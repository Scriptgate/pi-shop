package net.scriptgate.pi.shop.component;

import net.scriptgate.pi.shop.models.Product;
import net.scriptgate.pi.shop.service.CheckoutService;
import net.scriptgate.pi.shop.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class BarcodeScanner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(BarcodeScanner.class);

    @Autowired private CheckoutService checkoutService;
    @Autowired private ProductService productService;

    @Override
    public void run(String... args) {
        LOG.info("Barcode scanner online");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String barcode = scanner.nextLine();
            Optional<Product> product = productService.find(barcode);

            if (product.isPresent()) {
                checkoutService.add(product.get());
                LOG.info("Product added: {}", product.get().getName());
            } else {
                LOG.warn("Product with barcode '{}' not found", barcode);
            }
        }

    }
}
