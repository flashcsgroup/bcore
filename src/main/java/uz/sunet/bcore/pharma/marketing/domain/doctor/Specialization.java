package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Specialization {

    private String specializationName;

    public Specialization(String specializationName) {
        this.specializationName = specializationName;
    }

    public Specialization() {
    }

    public String getSpecializationName() {
        return specializationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (!specializationName.equals(that.specializationName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return specializationName.hashCode();
    }


    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
