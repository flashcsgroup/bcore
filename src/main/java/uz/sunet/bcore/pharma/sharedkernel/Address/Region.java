package uz.sunet.bcore.pharma.sharedkernel.Address;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Region {
    @Transient
    private String name;
    @Transient//TODO
    private Set<City> city;

    public Region() {
    }

    public Region(String name, Set<City> city) {
        this.name = name;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCity(Set<City> city) {
        this.city = city;
    }


    public Set<City> getCity() {
        return city;
    }
}
