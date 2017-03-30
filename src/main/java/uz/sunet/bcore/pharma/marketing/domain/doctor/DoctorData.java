package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class DoctorData {

    private AggregateId doctorId;
    private FullName fullName;
    private Set<Specialization> specializations;
    private Loyalty loyalty;
    private Category category;

    public DoctorData(AggregateId doctorId, FullName fullName, Set<Specialization> specializations, Loyalty loyalty, Category category) {
        this.doctorId = doctorId;
        this.fullName = fullName;
        this.specializations = specializations;
        this.loyalty = loyalty;
        this.category = category;
    }

    public AggregateId getDoctorId() {
        return doctorId;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public Loyalty getLoyalty() {
        return loyalty;
    }

    public Category getCategory() {
        return category;
    }
}
