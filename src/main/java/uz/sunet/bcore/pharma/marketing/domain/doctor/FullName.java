package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class FullName {

    @Embedded
    private String firstName;
    @Embedded
    private String lastName;
    @Embedded
    private String middleName;

    public FullName(String name, String lastName, String middleName) {
        this.firstName = name;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullName fullName = (FullName) o;

        if (!lastName.equals(fullName.lastName)) return false;
        if (!middleName.equals(fullName.middleName)) return false;
        if (!firstName.equals(fullName.firstName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        return result;
    }

    //SETTERS CREATED FOR JPA WORKING PROPERLY
    public void setName(String name) {
        this.firstName = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
