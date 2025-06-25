package net.scriptgate.pi.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"net.scriptgate.pi.shop"})
public class PiShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiShopApplication.class, args);
    }

}
