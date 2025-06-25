package net.scriptgate.pi.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestForwardingController {

    private static final Logger LOG = LoggerFactory.getLogger(RequestForwardingController.class);

    @RequestMapping(value = {
            "/pi-shop",
            "/pi-shop/",
            "/pi-shop/{path:[^\\.]*}"
    })
    public String redirect() {
        LOG.debug("Forwarding to /pi-shop/");
        // Forward to home page so that angular routing is preserved
        return "forward:/";
    }
}
