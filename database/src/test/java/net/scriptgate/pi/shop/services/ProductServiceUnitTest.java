package net.scriptgate.pi.shop.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceUnitTest {

    @Autowired private ProductService productService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        assertThat(productService.list()).hasSize(6);
    }
}
