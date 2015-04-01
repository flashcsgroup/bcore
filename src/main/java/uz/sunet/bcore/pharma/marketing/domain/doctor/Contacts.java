package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Contacts {
    @Transient//TODO:
    private List<String> phoneNumber;
    private String email;
    private String fax;

    public Contacts() {
    }

    public Contacts(List<String> phoneNumber, String email, String fax) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fax = fax;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
