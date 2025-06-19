package net.scriptgate.pi.shop.models;

public class ProductBuilder {

    private final String name;
    private String image;
    private String type;
    private String barcode;
    private double price;

    private ProductBuilder(String name) {
        this.name = name;
    }

    public static ProductBuilder product(String name) {
        return new ProductBuilder(name);
    }

    public Product build() {
        Product product = new Product();
        product.setName(name);
        product.setImage(image);
        product.setType(type);
        product.setBarcode(barcode);
        product.setPrice(price);
        return product;
    }

    public ProductBuilder image(String image) {
        this.image = image;
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
