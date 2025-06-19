package net.scriptgate.pi.shop.models;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 512_000)
    private String image;
    private String type;
    private String barcode;
    private double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    void setName(String name) {
        this.name = name;
    }

    void setImage(String image) {
        this.image = image;
    }

    void setType(String type) {
        this.type = type;
    }

    void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    void setPrice(double price) {
        this.price = price;
    }
}
