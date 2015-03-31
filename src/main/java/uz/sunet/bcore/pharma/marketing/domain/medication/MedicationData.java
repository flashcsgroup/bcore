package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;
import uz.sunet.bcore.pharma.sharedkernel.Money;

import java.util.Date;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class MedicationData {
    private AggregateId medicationId;
    private String name;
    private MedicationCategory category;
    private MedicationGroup group;
    private Money price;
    private Point points;
    private Annotation annotation;
    private MedicationType medicationType;
    private Date expirationDate;
    private Date productionDate;

    public MedicationData(AggregateId medicationId, String name, MedicationCategory category, MedicationGroup group, Money price, Point points, Annotation annotation, MedicationType medicationType, Date expirationDate, Date productionDate) {
        this.medicationId = medicationId;
        this.name = name;
        this.category = category;
        this.group = group;
        this.price = price;
        this.points = points;
        this.annotation = annotation;
        this.medicationType = medicationType;
        this.expirationDate = expirationDate;
        this.productionDate = productionDate;
    }

    public AggregateId getMedicationId() {
        return medicationId;
    }

    public String getName() {
        return name;
    }

    public MedicationCategory getCategory() {
        return category;
    }

    public MedicationGroup getGroup() {
        return group;
    }

    public Money getPrice() {
        return price;
    }

    public Point getPoints() {
        return points;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public MedicationType getMedicationType() {
        return medicationType;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicationData that = (MedicationData) o;

        if (!medicationId.equals(that.medicationId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return medicationId.hashCode();
    }
}
