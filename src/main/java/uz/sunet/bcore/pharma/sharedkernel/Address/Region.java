package uz.sunet.bcore.pharma.sharedkernel.Address;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Region {

    private String name;

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

    @ElementCollection
    @CollectionTable
    public Set<City> getCity() {
        return city;
    }
}
