package uz.sunet.bcore.pharma.sharedkernel.Address;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class City {

    private String name;
    private Integer population;

    public City() {
    }

    public City(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getPopulation() {
        return population;
    }
}
