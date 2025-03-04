package net.scriptgate.pi.shop.controller.model;

import java.util.List;

import static net.scriptgate.pi.shop.controller.model.HousingLocationBuilder.housingLocation;

public class HousingLocations {

    private static List<HousingLocation> locations;

    static {
        locations = List.of(
                housingLocation(0, "Acme Fresh Start Housing")
                        .location("Chicago", "IL")
                        .photo("https://angular.dev/assets/images/tutorials/common/bernard-hermant-CLKGGwIBTaY-unsplash.jpg")
                        .information(4, true, true)
                        .build(),
                housingLocation(1, "A113 Transitional Housing")
                        .location("Santa Monica", "CA")
                        .photo("https://angular.dev/assets/images/tutorials/common/brandon-griggs-wR11KBaB86U-unsplash.jpg")
                        .information(0, false, true)
                        .build(),
                housingLocation(2, "Warm Beds Housing Support")
                        .location("Juneau", "AK")
                        .photo("https://angular.dev/assets/images/tutorials/common/i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg")
                        .information(1, false, false)
                        .build(),
                housingLocation(3, "Homesteady Housing")
                        .location("Chicago", "IL")
                        .photo("https://angular.dev/assets/images/tutorials/common/ian-macdonald-W8z6aiwfi1E-unsplash.jpg")
                        .information(1, true, false)
                        .build(),
                housingLocation(4, "Happy Homes Group")
                        .location("Gary", "IN")
                        .photo("https://angular.dev/assets/images/tutorials/common/krzysztof-hepner-978RAXoXnH4-unsplash.jpg")
                        .information(1, true, false)
                        .build(),
                housingLocation(5, "Hopeful Apartment Group")
                        .location("Oakland", "CA")
                        .photo("https://angular.dev/assets/images/tutorials/common/r-architecture-JvQ0Q5IkeMM-unsplash.jpg")
                        .information(2, true, true)
                        .build(),
                housingLocation(6, "Seriously Safe Towns")
                        .location("Oakland", "CA")
                        .photo("https://angular.dev/assets/images/tutorials/common/phil-hearing-IYfp2Ixe9nM-unsplash.jpg")
                        .information(5, true, true)
                        .build(),
                housingLocation(7, "Hopeful Housing Solutions")
                        .location("Oakland", "CA")
                        .photo("https://angular.dev/assets/images/tutorials/common/r-architecture-GGupkreKwxA-unsplash.jpg")
                        .information(2, true, true)
                        .build(),
                housingLocation(8, "Seriously Safe Towns")
                        .location("Oakland", "CA")
                        .photo("https://angular.dev/assets/images/tutorials/common/saru-robert-9rP3mxf8qWI-unsplash.jpg")
                        .information(10, false, false)
                        .build(),
                housingLocation(9, "Capital Safe Towns")
                        .location("Portland", "OR")
                        .photo("https://angular.dev/assets/images/tutorials/common/webaliser-_TPTXZd9mOo-unsplash.jpg")
                        .information(6, true, true)
                        .build()
        );
    }

    public static List<HousingLocation> all() {
        return locations;
    }

    public static HousingLocation byId(int id) {
        return locations.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }
}
