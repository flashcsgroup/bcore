package uz.sunet.bcore.pharma.contract.domain.condition;


import org.springframework.util.Assert;
import uz.sunet.bcore.pharma.contract.domain.ConditionAbstraction;
import uz.sunet.bcore.pharma.sharedkernel.exceptions.DomainOperationException;

import java.util.HashSet;

/**
 * @author Jasurbek Khajiev
 */

public class Condition implements ConditionAbstraction {

    private ConditionType conditionType;
    private HashSet<ConditionItem> conditionItems = new HashSet<>();
    private ConditionDuration conditionDuration;

    public Condition(ConditionType conditionType, HashSet<ConditionItem> conditionItems, ConditionDuration conditionDuration) {
        if (conditionAllowsCreation(conditionType, conditionItems)) {
            this.conditionType = conditionType;
            this.conditionItems = conditionItems;
            this.conditionDuration = conditionDuration;
        } else {
            throw new DomainOperationException(null, "");
        }
    }

    public void setConditionDuration(ConditionDuration conditionDuration) {
        this.conditionDuration = conditionDuration;
    }

    public ConditionDuration getContractDuration() {
        return this.conditionDuration;
    }

    public HashSet<ConditionItem> getConditionItems() {
        return conditionItems;
    }

    public void setConditionItems(HashSet<ConditionItem> conditionItems) {
        this.conditionItems = conditionItems;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    private boolean conditionAllowsCreation(ConditionType conditionType, HashSet<ConditionItem> conditionItems) {
        //if(conditionType == ConditionType.SPECIAL_CONDITION || conditionItems.size()< 5)return false;
        if(conditionType == ConditionType.SPECIAL_CONDITION && conditionItems.size()< 5){
            return false;
        }
        if(conditionType == ConditionType.RECEIPT && conditionItems.size()< 5){
            return false;
        }
        for (ConditionItem conditionItem : conditionItems) {
            if (conditionType.equals(ConditionType.SPECIAL_CONDITION)) {
                Assert.notNull(conditionItem.getPharmacyId());
            }
            if (conditionType.equals(ConditionType.SPECIAL_POINTS)) {
                Assert.notNull(conditionItem.getPharmacyId());
                Assert.notNull(conditionItem.getPercent());
            }
        }
        return true;
    }

    public boolean conditionItemExists(Condition condition, ConditionItem conditionItem) {
        return condition.getConditionItems().contains(conditionItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        //if (conditionType != condition.conditionType) return false;
        return conditionType == condition.conditionType;

    }

    @Override
    public int hashCode() {
        return conditionType.hashCode();
    }

    //I MIGHT NEED THIS METHOD LATER LET IT JUST BE NOT IMPLEMENTED BY NOW
    /*public Condition mergeSimilarConditions(Set<Condition> conditions) throws Exception
    {
        ConditionType cType;
        return null;
    }*/
}
