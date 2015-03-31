package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.AggregateRoot;
import uz.sunet.bcore.ddd.support.domain.BaseAggregateRoot;

import javax.persistence.Entity;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Jasurbek Khajiev
 */
@Entity
@AggregateRoot
public class Doctor extends BaseAggregateRoot{

    private FullName fullName;
    private Age age;
    private HashSet<Specialization> specializations;
    private WorkPlace workPlace;
    private Position position;
    private Contacts contacts;
    private Category category;
    private Loyalty loyalty;
    private Date cooperationStartDate;

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public HashSet<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(HashSet<Specialization> specializations) {
        this.specializations = specializations;
    }

    public WorkPlace getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(WorkPlace workPlace) {
        this.workPlace = workPlace;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Loyalty getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Loyalty loyalty) {
        this.loyalty = loyalty;
    }

    public Date getCooperationStartDate() {
        return cooperationStartDate;
    }

    public void setCooperationStartDate(Date cooperationStartDate) {
        this.cooperationStartDate = cooperationStartDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (!age.equals(doctor.age)) return false;
        if (!fullName.equals(doctor.fullName)) return false;
        if (!workPlace.equals(doctor.workPlace)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + workPlace.hashCode();
        return result;
    }

    public DoctorData generateSnapshot() {
        return new DoctorData(getAggregateId(),fullName, specializations,loyalty,category);
    }

}
