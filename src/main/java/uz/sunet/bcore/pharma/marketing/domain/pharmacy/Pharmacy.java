package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.AggregateRoot;
import uz.sunet.bcore.ddd.support.domain.BaseAggregateRoot;
import uz.sunet.bcore.pharma.marketing.domain.doctor.DoctorData;
import uz.sunet.bcore.pharma.marketing.domain.sharedVO.Contacts;
import uz.sunet.bcore.pharma.sharedkernel.Address.Address;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Jonik Negmatov
 */
@Entity
@AggregateRoot
public class Pharmacy extends BaseAggregateRoot{

    @Embedded
    private String nameOfPharmacy;
    @Embedded
    private Date pharmacyCooperationDate;
    @Embedded
    private Double prepaymentPercentage;
    @Embedded
    private Contacts pharmacyContacts;
    @CollectionTable(
            name="pharmacy_staff",
            joinColumns=@JoinColumn(name="parent_id")
    )
    @Column(name="pharmacyStaff")
    private HashSet<PharmacyStaff> pharmacyStaff;
    @Enumerated(EnumType.STRING)
    private Potential potential;
    @Embedded
    private Address pharmacyAddress;

    public String getNameOfPharmacy() {
        return nameOfPharmacy;
    }

    public void setNameOfPharmacy(String nameOfPharmacy) {
        this.nameOfPharmacy = nameOfPharmacy;
    }

    public Date getPharmacyCooperationDate() {
        return pharmacyCooperationDate;
    }

    public void setPharmacyCooperationDate(Date pharmacyCooperationDate) {
        this.pharmacyCooperationDate = pharmacyCooperationDate;
    }

    public Double getPrepaymentPercentage() {
        return prepaymentPercentage;
    }

    public void setPrepaymentPercentage(Double prepaymentPercentage) {
        this.prepaymentPercentage = prepaymentPercentage;
    }

    public Contacts getPharmacyContacts() {
        return pharmacyContacts;
    }

    public void setPharmacyContacts(Contacts pharmacyContacts) {
        this.pharmacyContacts = pharmacyContacts;
    }

    public HashSet<PharmacyStaff> getPharmacyStaff() {
        return pharmacyStaff;
    }

    public void setPharmacyStaff(HashSet<PharmacyStaff> pharmacyStaff) {
        this.pharmacyStaff = pharmacyStaff;
    }

    public Potential getPotential() {
        return potential;
    }

    public void setPotential(Potential potential) {
        this.potential = potential;
    }

    public Address getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(Address pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pharmacy pharmacy = (Pharmacy) o;

        if (!nameOfPharmacy.equals(pharmacy.nameOfPharmacy)) return false;
        if (!pharmacyAddress.equals(pharmacy.pharmacyAddress)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + nameOfPharmacy.hashCode();
        result = 31 * result + pharmacyAddress.hashCode();
        return result;
    }
    public PharmacyData generateSnapshot() {
        return new PharmacyData(getAggregateId(),nameOfPharmacy,pharmacyCooperationDate,potential);
    }
}
