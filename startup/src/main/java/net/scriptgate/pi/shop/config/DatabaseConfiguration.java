package net.scriptgate.pi.shop.config;

import net.scriptgate.pi.shop.adapters.ProductRepositoryUsingH2;
import net.scriptgate.pi.shop.ports.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    private final ProductRepositoryUsingH2 productRepositoryUsingH2;

    public DatabaseConfiguration(ProductRepositoryUsingH2 productRepositoryUsingH2) {
        this.productRepositoryUsingH2 = productRepositoryUsingH2;
    }

    @Bean
    public ProductRepository productRepository() {
        return productRepositoryUsingH2;
    }

}
