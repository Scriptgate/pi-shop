package net.scriptgate.pi.shop.controller.model;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ProductDTOsToSqlTest {

    @Test
    void exportProductsToSql() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("build/import.sql"))) {
            ProductDTOs.all().forEach(product -> {
                writer.print("insert into product(name, image, type, barcode, price) values(");
                writer.print("'" + product.getName() + "', ");
                writer.print("'" + product.getImage() + "', ");
                writer.print("'" + product.getType() + "', ");
                writer.print("'" + product.getBarcode() + "', ");
                writer.print(product.getPrice() + ");");
            });
        }
    }

    @Test
    void maximumImageSize() {
        ProductDTOs.all()
                .stream()
                .map(ProductDTO::getImage)
                .mapToInt(String::length)
                .max()
                .ifPresent(System.out::println);
    }
}
