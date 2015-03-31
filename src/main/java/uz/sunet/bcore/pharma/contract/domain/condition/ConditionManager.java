package uz.sunet.bcore.pharma.contract.domain.condition;

import uz.sunet.bcore.pharma.contract.domain.Contract;

import java.util.HashSet;

/**
 * @author Jasurbek Khajiev
 */

public class ConditionManager  {
    //TODO test implemented logic of creation

    //Condition has Type Items and Duration;
    //Items have MedicationID, Amount, PharmacyID, percentage;
    private HashSet<Condition> conditions;
    private ConditionAdditionPolicyImplementation conditionAdditionPolicyImplementation;

//TODO Condition Addition Policy allows or not
    //yet it is created just as methods in a class

    public Contract addConditions(Contract contract, HashSet<Condition> conditionHashSet) throws Exception {
        conditionAdditionPolicyImplementation = new ConditionAdditionPolicyImplementation();
        boolean canAddAll = true;
        if (contract.getConditions() == null || contract.getConditions().size() == 0)
            conditionAdditionPolicyImplementation.canAdd(conditionHashSet);
        for (Condition condition : conditionHashSet) {
            if (conditionAdditionPolicyImplementation.canAdd(condition, contract.getConditions())) ;
            else canAddAll = false;
        }
        if (canAddAll) {
            this.conditions.addAll(conditionHashSet);
            contract.setConditions(this.conditions);
            return contract;
        } else throw new IllegalArgumentException("Cannot add conditions to the system");
    }

    public Contract addCondition(Contract contract, Condition condition) throws Exception {
        if (contract.getConditions() == null || conditionAdditionPolicyImplementation.canAdd(condition, contract.getConditions())) {
            this.conditions = new HashSet<Condition>();
            this.conditions.add(condition);
            contract.setConditions(this.conditions);
            return contract;
        } else throw new IllegalArgumentException("Cannot add condition to the system");
    }

}


