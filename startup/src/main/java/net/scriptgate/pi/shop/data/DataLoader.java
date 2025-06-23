package net.scriptgate.pi.shop.data;

import net.scriptgate.pi.shop.ports.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DataLoader implements ApplicationRunner {

    private ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        productRepository.save("Frietjes", image("images/fries.png"), "FOOD", "1001", "5.00");
        productRepository.save("Broodje", image("images/bread.png"), "FOOD", "1002", "3.00");
        productRepository.save("Koffie", image("images/coffee.png"), "DRINK", "1003", "12.00");
        productRepository.save("Appelsiensap", image("images/juice.png"), "DRINK", "1004", "4.00");
        productRepository.save("Donuts", image("images/donuts.png"), "FOOD", "1005", "18.00");
        productRepository.save("Koekjes", image("images/cookies.png"), "FOOD", "1006", "25.00");
    }

    private byte[] image(String path) {
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if (input == null) {
                throw new FileNotFoundException(path);
            }
            return input.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}