package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class MedicationGroup {
    private RegionData region;
    //TODO RECONSIDER THIS PART
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