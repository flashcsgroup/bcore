package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.AggregateRoot;
import uz.sunet.bcore.ddd.support.domain.BaseAggregateRoot;
import uz.sunet.bcore.pharma.marketing.domain.doctor.Specialization;
import uz.sunet.bcore.pharma.sharedkernel.Money;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Jasurbek Khajiev
 */
@Entity
@AggregateRoot
public class Medication extends BaseAggregateRoot{
    private String name;
    @Enumerated(EnumType.STRING)
    private MedicationCategory category;
    @Embedded
    private MedicationGroup group;
    @Embedded
    private Money price;
    @Embedded
    private Point points;
    @Enumerated(EnumType.STRING)
    private MedicationType medicationType;
    @Embedded
    private Annotation annotation;
    private Date expirationDate;
    private Date productionDate;
    @Transient
    private List<Promotion> promotion;
    //TO BE SEPARATED AS AGGREGATE OR SHARER KERNEL
    @Transient
    private List<Specialization> usageArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedicationCategory getCategory() {
        return category;
    }

    public void setCategory(MedicationCategory category) {
        this.category = category;
    }

    public MedicationGroup getGroup() {
        return group;
    }

    public void setGroup(MedicationGroup group) {
        this.group = group;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Point getPoints() {
        return points;
    }

    public void setPoints(Point points) {
        this.points = points;
    }

    public MedicationType getMedicationType() {
        return medicationType;
    }

    public void setMedicationType(MedicationType medicationType) {
        this.medicationType = medicationType;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public List<Promotion> getPromotion() {
        return promotion;
    }

    public void setPromotion(List<Promotion> promotion) {
        this.promotion = promotion;
    }

    public List<Specialization> getUsageArea() {
        return usageArea;
    }

    public void setUsageArea(List<Specialization> usageArea) {
        this.usageArea = usageArea;
    }

    //TODO DECIDE HOW CAN A MEDICATION BE DISTINGUISHED FROM ANOTHER MEDICATION
}
