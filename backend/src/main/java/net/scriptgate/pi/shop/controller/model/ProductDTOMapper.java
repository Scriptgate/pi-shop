package net.scriptgate.pi.shop.controller.model;

import net.scriptgate.pi.shop.controller.model.ProductDTO;
import net.scriptgate.pi.shop.models.Product;

public class ProductDTOMapper {

    public static ProductDTO map(Product product) {
        ProductDTO result = new ProductDTO();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setImage(product.getImage());
        result.setType(product.getType());
        result.setBarcode(product.getBarcode());
        result.setPrice(product.getPrice());
        return result;
    }

}
