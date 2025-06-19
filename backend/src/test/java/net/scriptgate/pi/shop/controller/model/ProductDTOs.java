package net.scriptgate.pi.shop.controller.model;

import java.util.List;

import static net.scriptgate.pi.shop.controller.model.ProductDTOTestBuilder.product;

public class ProductDTOs {

    private static int idSequence = 0;
    private static int barcodeSequence = 1000;
    private static final List<ProductDTO> products;

    static {
        products = List.of(
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
        );
    }

    public static int nextId() {
        return ++idSequence;
    }

    public static String nextBarcode() {
        return String.valueOf(++barcodeSequence);
    }

    public static List<ProductDTO> all() {
        return products;
    }
}
