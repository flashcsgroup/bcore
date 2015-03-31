package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;
import uz.sunet.bcore.pharma.marketing.domain.sharedVO.Contacts;

import java.util.Date;
import java.util.HashSet;

/**
 * @author Jonik Negmatov
 */
@ValueObject
public class PharmacyData {
    private AggregateId pharmacyId;
    private String nameOfPharmacy;
    private Date pharmacyCooperationDate;
    private Double prepaymentPercentage;
    private Contacts pharmacyContacts;
    private HashSet<PharmacyStaff> pharmacyStaff;
    private Potential potential;

    public AggregateId getPharmacyId() {
        return pharmacyId;
    }

    public String getNameOfPharmacy() {
        return nameOfPharmacy;
    }

    public Date getPharmacyCooperationDate() {
        return pharmacyCooperationDate;
    }

    public Double getPrepaymentPercentage() {
        return prepaymentPercentage;
    }

    public Contacts getPharmacyContacts() {
        return pharmacyContacts;
    }

    public HashSet<PharmacyStaff> getPharmacyStaff() {
        return pharmacyStaff;
    }

    public Potential getPotential() {
        return potential;
    }

    public PharmacyData(AggregateId pharmacyId, String nameOfPharmacy, Date pharmacyCooperationDate, Double prepaymentPercentage, Contacts pharmacyContacts, HashSet<PharmacyStaff> pharmacyStaff, Potential potential) {
        this.pharmacyId = pharmacyId;
        this.nameOfPharmacy = nameOfPharmacy;
        this.pharmacyCooperationDate = pharmacyCooperationDate;
        this.prepaymentPercentage = prepaymentPercentage;
        this.pharmacyContacts = pharmacyContacts;
        this.pharmacyStaff = pharmacyStaff;
        this.potential = potential;
    }



}
