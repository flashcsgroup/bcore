package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class MedicationGroup {
    @Embedded
    private RegionData region;
    //TODO RECONSIDER THIS PART
    @Enumerated(EnumType.STRING)
    private Group group;

    public MedicationGroup(RegionData region, Group group) {
        this.region = region;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public RegionData getRegion() {
        return region;
    }
}