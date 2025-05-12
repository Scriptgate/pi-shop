package net.scriptgate.pi.shop.controller.model;

import java.util.List;

import static net.scriptgate.pi.shop.controller.model.ProductBuilder.product;

public class Products {

    private static List<Product> products;

    static {
        products = List.of(
                product(0, "Frietjes")
                        .image("/assets/images/fries.png")
                        .type("FOOD")
                        .barcode("1001")
                        .price(5.00)
                        .build(),
                product(1, "Broodje")
                        .image("/assets/images/bread.png")
                        .type("FOOD")
                        .barcode("1002")
                        .price(3.00)
                        .build(),
                product(2, "Koffie")
                        .image("/assets/images/coffee.png")
                        .type("DRINK")
                        .barcode("1003")
                        .price(12.00)
                        .build(),
                product(3, "Appelsiensap")
                        .image("/assets/images/juice.png")
                        .type("DRINK")
                        .barcode("1004")
                        .price(4.00)
                        .build(),
                product(4, "Donuts")
                        .image("/assets/images/donuts.png")
                        .type("FOOD")
                        .barcode("1005")
                        .price(18.00)
                        .build(),
                product(5, "Koekjes")
                        .image("/assets/images/cookies.png")
                        .type("FOOD")
                        .barcode("1006")
                        .price(25.00)
                        .build()
        );
    }

    public static List<Product> all() {
        return products;
    }

    public static Product byId(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

}
