package net.scriptgate.pi.shop.controller.model;

import java.util.ArrayList;
import java.util.List;

import static net.scriptgate.pi.shop.controller.model.ProductBuilder.product;

public class Products {

    private static int idSequence = 0;
    private static int barcodeSequence = 1000;
    private static final List<Product> products;

    static {
        products = new ArrayList<>(List.of(
                product(nextId(), "Frietjes")
                        .image("assets/images/fries.png")
                        .type("FOOD")
                        .barcode(nextBarcode())
                        .price(5.00)
                        .build(),
                product(nextId(), "Broodje")
                        .image("assets/images/bread.png")
                        .type("FOOD")
                        .barcode(nextBarcode())
                        .price(3.00)
                        .build(),
                product(nextId(), "Koffie")
                        .image("assets/images/coffee.png")
                        .type("DRINK")
                        .barcode(nextBarcode())
                        .price(12.00)
                        .build(),
                product(nextId(), "Appelsiensap")
                        .image("assets/images/juice.png")
                        .type("DRINK")
                        .barcode(nextBarcode())
                        .price(4.00)
                        .build(),
                product(nextId(), "Donuts")
                        .image("assets/images/donuts.png")
                        .type("FOOD")
                        .barcode(nextBarcode())
                        .price(18.00)
                        .build(),
                product(nextId(), "Koekjes")
                        .image("assets/images/cookies.png")
                        .type("FOOD")
                        .barcode(nextBarcode())
                        .price(25.00)
                        .build()
        ));
    }

    public static int nextId() {
        return ++idSequence;
    }

    public static String nextBarcode() {
        return String.valueOf(++barcodeSequence);
    }

    public static Product create(Product product) {

        System.out.println("Name: "+product.getName()+", Image: "+product.getImage().length()+ ", Type: " + product.getType()+ ", Price: "+product.getPrice());

        product.setId(nextId());
        product.setBarcode(nextBarcode());
        products.add(product);
        return product;
    }

    public static List<Product> all() {
        return products;
    }

    public static Product byId(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

}
