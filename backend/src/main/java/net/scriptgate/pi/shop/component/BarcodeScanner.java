package net.scriptgate.pi.shop.component;

import net.scriptgate.pi.shop.models.Product;
import net.scriptgate.pi.shop.service.CheckoutService;
import net.scriptgate.pi.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class BarcodeScanner implements CommandLineRunner {

    @Autowired private CheckoutService checkoutService;
    @Autowired private ProductService productService;

    @Override
    public void run(String... args) {
        System.out.println("> Barcode scanner online");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String barcode = scanner.nextLine();
            Optional<Product> product = productService.find(barcode);

            if (product.isPresent()) {
                checkoutService.add(product.get());
                System.out.println("Product added: " + product.get().getName());
            } else {
                System.out.println("Product with barcode '" + barcode + "' not found");
            }
        }

    }
}
