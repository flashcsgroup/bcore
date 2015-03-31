package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;


import java.util.Date;

/**
 * @author Jonik Negmatov
 */
@ValueObject
public class PharmacyData {
    private AggregateId pharmacyId;
    private String nameOfPharmacy;
    private Date pharmacyCooperationDate;
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

    public Potential getPotential() {
        return potential;
    }

    public PharmacyData(AggregateId pharmacyId, String nameOfPharmacy, Date pharmacyCooperationDate, Potential potential) {
        this.pharmacyId = pharmacyId;
        this.nameOfPharmacy = nameOfPharmacy;
        this.pharmacyCooperationDate = pharmacyCooperationDate;
        this.potential = potential;
    }



}
