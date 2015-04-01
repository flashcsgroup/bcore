package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.sharedkernel.Address.Address;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class WorkPlace {
    private String nameOfPlace;
    @Embedded
    private Address address;
    private String phoneNumber;

    private String email;

    private String fax;

    public WorkPlace(String nameOfPlace, Address address, String phoneNumber, String fax) {
        this.nameOfPlace = nameOfPlace;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
    }

    public String getNameOfPlace() {
        return nameOfPlace;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFax() {
        return fax;
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

    //CREATED FOR JPA TO WORK PROPERLY

    public void setNameOfPlace(String nameOfPlace) {
        this.nameOfPlace = nameOfPlace;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

}
