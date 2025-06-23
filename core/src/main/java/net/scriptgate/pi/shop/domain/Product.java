package net.scriptgate.pi.shop.domain;

public interface Product {

    Long getId();

    String getName();

    String getImage();

    String getType();

    String getBarcode();

    double getPrice();
}
