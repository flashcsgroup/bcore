package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import java.util.List;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Contacts {
    private List<String> phoneNumber;
    private String email;
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
}
