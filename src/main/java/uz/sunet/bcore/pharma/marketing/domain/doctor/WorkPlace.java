package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.sharedkernel.Address.Address;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class WorkPlace {

    private String nameOfPlace;
    private Address address;
    private Contacts contacts;

    public WorkPlace(String nameOfPlace, Address address, Contacts contacts) {
        this.nameOfPlace = nameOfPlace;
        this.address = address;
        this.contacts = contacts;
    }

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public Address getAddress() {
        return address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkPlace workPlace = (WorkPlace) o;

        if (!address.equals(workPlace.address)) return false;
        if (!nameOfPlace.equals(workPlace.nameOfPlace)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nameOfPlace.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
