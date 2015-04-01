package uz.sunet.bcore.pharma.marketing.domain.doctor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import uz.sunet.bcore.ddd.annotations.domain.AggregateRoot;
import uz.sunet.bcore.ddd.support.domain.BaseAggregateRoot;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */
@Entity
@AggregateRoot
public class Doctor extends BaseAggregateRoot {
    @Embedded
    private FullName fullName;

    @Embedded
    private Age age;

    @Transient
    private Set<Specialization> specializations;

    @Embedded
    private WorkPlace workPlace;

    @Embedded
    private Position position;

    @Transient//todo its duplicated with WorkPlace embedded contacts should be unique mapping
    private Contacts contacts;

    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
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

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
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
        if (!(o instanceof Doctor)) {
            return false;
        }
        final Doctor that = (Doctor) o;
        return new EqualsBuilder().append(age, that.age).append(fullName, that.fullName).append(workPlace, that.workPlace).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(age).append(fullName).append(workPlace).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("age", age).append("fullName", fullName).append("workPlace", workPlace).toString();
    }

    public DoctorData generateSnapshot() {
        return new DoctorData(getAggregateId(), fullName, specializations, loyalty, category);
    }

}
