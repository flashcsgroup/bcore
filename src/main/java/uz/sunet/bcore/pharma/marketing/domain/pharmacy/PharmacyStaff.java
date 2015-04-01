package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.marketing.domain.doctor.FullName;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author Jonik Negmatov
 */
@Embeddable
@ValueObject
public class PharmacyStaff {
    private String position;
    @Embedded
    private FullName pharmacyStuffName;
    private String phoneNumber;

    public PharmacyStaff(String position, FullName pharmacyStuffName, String phoneNumber) {
        this.position = position;
        this.pharmacyStuffName = pharmacyStuffName;
        this.phoneNumber = phoneNumber;
    }

    public PharmacyStaff() {
    }

    public String getPosition() {
        return position;
    }

    public FullName getPharmacyStuffName() {
        return pharmacyStuffName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
