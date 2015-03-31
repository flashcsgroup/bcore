package uz.sunet.bcore.pharma.sharedkernel.Address;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Address {
    private City city;
    private Region region;
    private String street;
    private String houseNumber;
    private String zipCode;

    public Address(City city, Region region, String street, String houseNumber, String zipCode) {
        this.city = city;
        this.region = region;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public Region getRegion() {
        return region;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!city.equals(address.city)) return false;
        if (!houseNumber.equals(address.houseNumber)) return false;
        if (!region.equals(address.region)) return false;
        if (!street.equals(address.street)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber.hashCode();
        return result;
    }
}
