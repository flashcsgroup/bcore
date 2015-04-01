package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class FullName {
    private String name;
    private String lastName;
    private String middleName;

    public FullName() {
    }

    public FullName(String name, String lastName, String middleName) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullName fullName = (FullName) o;

        if (!lastName.equals(fullName.lastName)) return false;
        if (!middleName.equals(fullName.middleName)) return false;
        if (!name.equals(fullName.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        return result;
    }
}
