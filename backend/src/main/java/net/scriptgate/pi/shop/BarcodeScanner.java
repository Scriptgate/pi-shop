package net.scriptgate.pi.shop;

import net.scriptgate.pi.shop.controller.model.Product;
import net.scriptgate.pi.shop.controller.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class BarcodeScanner implements CommandLineRunner {

    @Autowired
    private SimpMessagingTemplate template;

    private final List<Product> shoppingCart = new ArrayList<>();

    @Override
    public void run(String... args) {
        System.out.println("> Barcode scanner online");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String barcode = scanner.nextLine();
            Product product = Products.byBarcode(barcode);
            if (product != null) {
                shoppingCart.add(product);
                template.convertAndSend("/checkout/products", shoppingCart);
                System.out.println("Product added: " + product.getName());
            } else {
                System.out.println("Product with barcode '" + barcode + "' not found");
            }
        }

    }
}
