package net.scriptgate.pi.shop.controller.model;

public class HousingLocationBuilder {

    private final int id;
    private final String name;
    private String city;
    private String state;
    private String photo;
    private int availableUnits;
    private boolean wifi;
    private boolean laundry;

    private HousingLocationBuilder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static HousingLocationBuilder housingLocation(int id, String name) {
        return new HousingLocationBuilder(id, name);
    }

    public HousingLocation build() {
        HousingLocation location = new HousingLocation();
        location.setId(id);
        location.setName(name);
        location.setCity(city);
        location.setState(state);
        location.setPhoto(photo);
        location.setAvailableUnits(availableUnits);
        location.setWifi(wifi);
        location.setLaundry(laundry);
        return location;
    }

    public HousingLocationBuilder location(String city, String state) {
        this.city = city;
        this.state = state;
        return this;
    }

    public HousingLocationBuilder photo(String photo) {
        this.photo = photo;
        return this;
    }

    public HousingLocationBuilder information(int availableUnits, boolean wifi, boolean laundry) {
        this.availableUnits = availableUnits;
        this.wifi = wifi;
        this.laundry = laundry;
        return this;
    }
}
