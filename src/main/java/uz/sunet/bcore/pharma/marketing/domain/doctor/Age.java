package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import java.util.Date;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Age {
    private Date dob;
    private Integer age;

    public Age(Date dob) {
        this.dob = dob;
        Date currentDate = new Date();
        this.age = currentDate.getYear() - dob.getYear();
    }

    public Date getDob() {
        return dob;
    }

    public Integer getAge() {
        return (new Date().getYear() - dob.getYear());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Age age = (Age) o;

        if (!dob.equals(age.dob)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return dob.hashCode();
    }

    //CREATED FOR JPA TO WORK PROPERLY
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
