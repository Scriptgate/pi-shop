package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.ProductDTO;
import net.scriptgate.pi.shop.service.CheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class CheckoutController {

    private static final Logger LOG = LoggerFactory.getLogger(CheckoutController.class);

    @Autowired private CheckoutService checkoutService;

    @GetMapping("/checkout")
    public List<ProductDTO> getProducts() {
        return checkoutService.getProducts();
    }

    @DeleteMapping("/checkout/{id}")
    public void removeProductById(@PathVariable("id") int id) {
        LOG.info("Removing product with id '{}'", id);
        checkoutService.remove(id);
    }
}
