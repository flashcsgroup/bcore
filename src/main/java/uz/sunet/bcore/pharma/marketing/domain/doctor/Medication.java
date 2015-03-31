package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Medication {
    private AggregateId medicationId;
    private String medicationName;

    public Medication(AggregateId medicationId, String medicationName) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
    }

    public AggregateId getMedicationId() {
        return medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }
}
