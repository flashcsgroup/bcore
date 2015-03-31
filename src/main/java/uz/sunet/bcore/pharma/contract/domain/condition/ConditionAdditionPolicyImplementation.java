package uz.sunet.bcore.pharma.contract.domain.condition;

import uz.sunet.bcore.ddd.annotations.domain.DomainPolicyImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Jasurbek Khajiev
 */
@DomainPolicyImpl
public class ConditionAdditionPolicyImplementation implements ConditionAdditionPolicy {

    //TODO IMPLEMENT AMOUNT CHECKING POLICY, IF THE MEDICATION AMOUNT EXCEEDS MINIMUM LIMIT OF SPECIAL POINT CONDITIONS THEN CHANGE TO SPECIAL POINTS

    public boolean canAdd(Condition condition, HashSet<Condition> existingConditions) {
        boolean canAdd = true;
        if (existingConditions.isEmpty()) return canAdd;
        for (Condition existingCondition : existingConditions) {
            if (existingCondition.getConditionType() == condition.getConditionType() || existingCondition.getConditionType() == ConditionType.SPECIAL_POINTS)
                ;
            else canAdd = false;
        }
        return canAdd;
    }

    public boolean canAdd(HashSet<Condition> conditions) {
        boolean receiptExist = false;
        boolean specialConditionExist = false;
        for (Condition existingCondition : conditions) {
            if (existingCondition.getConditionType().equals(ConditionType.RECEIPT)) receiptExist = true;
            if (existingCondition.getConditionType().equals(ConditionType.SPECIAL_CONDITION))
                specialConditionExist = true;
        }
//        if (receiptExist && specialConditionExist) {
//            return false;
//        } else {
//            return true;
//        }
        return !(receiptExist && specialConditionExist);
    }

    public boolean canCreateReceiptCondition(Condition condition) {
        return condition.getConditionItems().size() >= 5;
    }

    public boolean canCreateSpecialCondition(Condition condition) {
        return condition.getConditionItems().size() >= 5;
    }

    public boolean canCreateSpecialPointCondition(Condition condition) {
        //TODO IMPLEMENTATION OF THE MEDICATION MIN LIMIT RETRIEVAL
        int minValueForMedication = 100;
        if (condition.getConditionItems().size() != 1) return false;
        List<ConditionItem> conditionItems = new ArrayList<>(condition.getConditionItems());
        if (conditionItems.get(0).getAmount() < minValueForMedication) return false;
        //if (conditionItems.get(0).getPercent() > 100.0) return false;
        return conditionItems.get(0).getPercent() <= 100.0;
    }

}
