package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.marketing.domain.sharedVO.Contacts;
import uz.sunet.bcore.pharma.marketing.domain.sharedVO.FullName;

import java.util.HashSet;

/**
 * @author Jonik Negmatov
 */
@ValueObject
public class PharmacyStaff {
    private String position;
    private FullName pharmacyStuffName;
    private String phoneNumber;

    public PharmacyStaff(String position, FullName pharmacyStuffName, String phoneNumber) {
        this.position = position;
        this.pharmacyStuffName = pharmacyStuffName;
        this.phoneNumber = phoneNumber;
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
