package uz.sunet.bcore.pharma.contract.domain.condition;

import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@uz.sunet.bcore.ddd.annotations.domain.ValueObject
public class ConditionItem {
    private AggregateId medicationId;
    private Integer amount;
    private AggregateId pharmacyId;
    private Double percent;

    public AggregateId getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(AggregateId medicationId) {
        this.medicationId = medicationId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public AggregateId getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(AggregateId pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ConditionItem that = (ConditionItem) o;

        return medicationId.equals(that.medicationId);

    }

    @Override
    public int hashCode() {
        return medicationId.hashCode();
    }
}
