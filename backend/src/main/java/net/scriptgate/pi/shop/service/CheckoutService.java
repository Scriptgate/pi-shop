package net.scriptgate.pi.shop.service;

import net.scriptgate.pi.shop.controller.model.ProductDTOMapper;
import net.scriptgate.pi.shop.controller.model.ProductDTO;
import net.scriptgate.pi.shop.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {

    private static final Logger LOG = LoggerFactory.getLogger(CheckoutService.class);

    @Autowired private SimpMessagingTemplate template;

    private final List<Product> shoppingCart = new ArrayList<>();

    public void add(Product product) {
        shoppingCart.add(0, product);
        template.convertAndSend("/checkout/products", getProducts());
    }

    public List<ProductDTO> getProducts() {
        return shoppingCart.stream().map(ProductDTOMapper::map).toList();
    }

    public void remove(int id) {
        Optional<Product> productToDelete = shoppingCart.stream().filter(product -> product.getId() == id).findFirst();
        if (productToDelete.isPresent()) {
            shoppingCart.remove(productToDelete.get());
            template.convertAndSend("/checkout/products", getProducts());
        } else {
            LOG.warn("Could not delete product: id '{}' not found", id);
        }
    }

    public void pay(String method) {
        shoppingCart.clear();
        template.convertAndSend("/checkout/products", getProducts());
    }
}
