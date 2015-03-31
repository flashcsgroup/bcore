package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Specialization {

    private String specializationName;

    public Specialization(String specializationName) {
        this.specializationName = specializationName;
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
}