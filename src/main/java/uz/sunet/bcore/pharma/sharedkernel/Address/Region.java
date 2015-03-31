package uz.sunet.bcore.pharma.sharedkernel.Address;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import java.util.HashSet;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Region {

    private String name;

    private HashSet<City> city;

    public Region(String name, HashSet<City> city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public HashSet<City> getCity() {
        return city;
    }
}
