package uz.sunet.bcore.pharma.marketing.domain.doctor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Age {

    private Date dateOfBirth;

    public Age() {
    }

    public Age(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @SuppressWarnings("JpaAttributeMemberSignatureInspection")
    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        LocalDate now = LocalDate.now();
        LocalDate birthday = LocalDate.of(calendar.get(Calendar.YEAR), Month.of(calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.DAY_OF_MONTH));
        return Period.between(birthday, now).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Age)) {
            return false;
        }
        final Age that = (Age) o;
        return new EqualsBuilder().append(dateOfBirth, that.dateOfBirth).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(dateOfBirth).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("dateOfBirth", dateOfBirth).toString();
    }

}
