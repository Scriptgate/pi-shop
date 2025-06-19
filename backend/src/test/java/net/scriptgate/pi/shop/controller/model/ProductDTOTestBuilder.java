package net.scriptgate.pi.shop.controller.model;

import java.io.*;
import java.util.Base64;

public class ProductDTOTestBuilder {

    private final long id;
    private final String name;
    private String image;
    private String type;
    private String barcode;
    private double price;

    private ProductDTOTestBuilder(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductDTOTestBuilder product(long id, String name) {
        return new ProductDTOTestBuilder(id, name);
    }

    public ProductDTO build() {
        ProductDTO product = new ProductDTO();
        product.setId(id);
        product.setName(name);
        product.setImage(image);
        product.setType(type);
        product.setBarcode(barcode);
        product.setPrice(price);
        return product;
    }

    public ProductDTOTestBuilder image(String path) {
        try(InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if(input == null) {
                throw new FileNotFoundException(path);
            }
            return image(input.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDTOTestBuilder image(byte[] data) {
        this.image = "data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(data);
        return this;
    }

    public ProductDTOTestBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ProductDTOTestBuilder barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public ProductDTOTestBuilder price(double price) {
        this.price = price;
        return this;
    }

}
