package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.DomainFactory;
import uz.sunet.bcore.pharma.marketing.domain.sharedVO.Contacts;
import uz.sunet.bcore.pharma.sharedkernel.Address.Address;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author Jonik Negmatov
 */
@DomainFactory
public class PharmacyFactory {
    public Pharmacy create(String nameOfPharmacy,Date pharmacyCooperationDate,Double prepaymentPercentage,
    HashSet<PharmacyStaff>pharmacyStaff,Potential potential,Address pharmacyAddress,
    List<String> phoneNumber,String email,String fax)
    {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setNameOfPharmacy(nameOfPharmacy);
        pharmacy.setPharmacyCooperationDate(pharmacyCooperationDate);
        pharmacy.setPrepaymentPercentage(prepaymentPercentage);
        pharmacy.setPharmacyContacts(createContacts(phoneNumber,email,fax));
        HashSet<PharmacyStaff> pharmacyStaffSet = new HashSet<PharmacyStaff>();
        pharmacyStaffSet.addAll(pharmacyStaff);
        pharmacy.setPharmacyStaff(pharmacyStaffSet);
        pharmacy.setPotential(potential);
        pharmacy.setPharmacyAddress(pharmacyAddress);

    return pharmacy;
    }
    public Contacts createContacts(List<String> phoneNumber,String email,String fax) {
        return new Contacts(phoneNumber, email, fax);
    }
}
