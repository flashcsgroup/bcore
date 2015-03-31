package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Pharmacy {
    private AggregateId pharmacyId;
    private String pharmacyName;

    public Pharmacy(AggregateId pharmacyId, String pharmacyName) {
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
    }

    public AggregateId getPharmacyId() {
        return pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }
}
