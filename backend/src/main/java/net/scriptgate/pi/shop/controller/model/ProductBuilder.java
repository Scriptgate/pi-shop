package net.scriptgate.pi.shop.controller.model;

import net.scriptgate.pi.shop.util.ImageResizer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class ProductBuilder {

    private final int id;
    private final String name;
    private String image;
    private String type;
    private String barcode;
    private double price;

    private ProductBuilder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductBuilder product(int id, String name) {
        return new ProductBuilder(id, name);
    }

    public Product build() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setImage(image);
        product.setType(type);
        product.setBarcode(barcode);
        product.setPrice(price);
        return product;
    }

    public ProductBuilder image(String path) {
        try(InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if(input == null) {
                throw new FileNotFoundException(path);
            }
            return image(input.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ProductBuilder image(byte[] data) {
        this.image = "data:image/jpeg;base64,"+ Base64.getEncoder().encodeToString(ImageResizer.resize(data));
        return this;
    }

    public ProductBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public ProductBuilder price(double price) {
        this.price = price;
        return this;
    }

}
