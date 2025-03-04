package net.scriptgate.pi.shop.controller;

import net.scriptgate.pi.shop.controller.model.HousingLocation;
import net.scriptgate.pi.shop.controller.model.HousingLocations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend")
public class HousingLocationController {

    @GetMapping("/locations")
    public List<HousingLocation> getLocations() {
        return HousingLocations.all();
    }

    @GetMapping("/locations/{id}")
    public HousingLocation getLocationById(@PathVariable("id") int id) {
        return HousingLocations.byId(id);
    }
}
