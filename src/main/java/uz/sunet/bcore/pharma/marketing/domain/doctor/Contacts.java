package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Contacts {
    @ElementCollection
    @CollectionTable(
            name="doctor_contactPhones",
            joinColumns=@JoinColumn(name="parent_id")
    )
    @Column(name="phoneNumber")
    private List<String> phoneNumber;
    @Embedded
    private String email;
    @Embedded
    private String fax;

    public Contacts(List<String> phoneNumber, String email, String fax) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fax = fax;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    //CREATED FOR JPA TO WORK PROPERLY


    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
