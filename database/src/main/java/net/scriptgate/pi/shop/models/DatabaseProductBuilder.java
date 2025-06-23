package net.scriptgate.pi.shop.models;

public class DatabaseProductBuilder {

    private final String name;
    private String image;
    private String type;
    private String barcode;
    private double price;

    private DatabaseProductBuilder(String name) {
        this.name = name;
    }

    public static DatabaseProductBuilder product(String name) {
        return new DatabaseProductBuilder(name);
    }

    public DatabaseProduct build() {
        DatabaseProduct product = new DatabaseProduct();
        product.setName(name);
        product.setImage(image);
        product.setType(type);
        product.setBarcode(barcode);
        product.setPrice(price);
        return product;
    }

    public DatabaseProductBuilder image(String image) {
        this.image = image;
        return this;
    }

    public DatabaseProductBuilder type(String type) {
        this.type = type;
        return this;
    }

    public DatabaseProductBuilder barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public DatabaseProductBuilder price(double price) {
        this.price = price;
        return this;
    }

}
