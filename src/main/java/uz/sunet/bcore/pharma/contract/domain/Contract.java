package uz.sunet.bcore.pharma.contract.domain;


import uz.sunet.bcore.ddd.annotations.domain.AggregateRoot;
import uz.sunet.bcore.ddd.support.domain.BaseAggregateRoot;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;
import uz.sunet.bcore.pharma.contract.domain.condition.Condition;
import uz.sunet.bcore.pharma.contract.domain.condition.ConditionAdditionPolicyImplementation;
import uz.sunet.bcore.pharma.contract.domain.condition.ConditionItem;
import uz.sunet.bcore.pharma.contract.domain.condition.ConditionType;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */
@javax.persistence.Entity
@AggregateRoot
public class Contract extends BaseAggregateRoot {
//PROBABLY I WILL NEED TO CHANGE DATA TYPE OF FOREIGN KEYS
    @Transient//todo
    private AggregateId representativeId;
    @Transient//todo
    private AggregateId doctorId;
    @Transient//todo
    private Set<Condition> conditions = new HashSet<>();
    @Transient
    private ConditionAdditionPolicyImplementation policyImplementation;


    //AGGREGATE ROOT IS GENERATED IN FACTORY

    @Override
    public AggregateId getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(AggregateId aggregateId) {
        this.aggregateId = aggregateId;
    }

    public AggregateId getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(AggregateId representativeId) {

        this.representativeId = representativeId;
    }

    public AggregateId getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(AggregateId doctorId) {
        this.doctorId = doctorId;
    }

    public Set<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(HashSet<Condition> conditions) {
        this.conditions = conditions;
    }

    //Tekshiradigan metodlar
    //TODO: IMPROVE IMPLEMENTATION OF addNewCondition METHOD
    public void addNewCondition(Condition condition) {
        if (canCreateConditionPolicy(condition))
            this.conditions.add(condition);
        if (contains(condition)) modifyCondition(condition);
    }


    //TODO: IMPROVE IMPLEMENTATION OF modifyCondition METHOD
    public void modifyCondition(Condition condition) {
        List<Condition> tempCondition = new ArrayList<>(this.conditions);
        for (Condition cond : this.conditions) {
            if (cond.equals(condition)) {
                HashSet<ConditionItem> conditionItems = cond.getConditionItems();
                conditionItems.addAll(condition.getConditionItems());
                cond.setConditionItems(conditionItems);
            }
            tempCondition.set(tempCondition.indexOf(cond), cond);
        }
        this.conditions.clear();
        this.conditions.addAll(tempCondition);
    }

    //TODO: IMPLEMENTATION OF contains METHOD, PROBABLY THERE IS NO NEED TO DO THAT
    public boolean contains(Condition checkingCondition) {
        return this.getConditions().contains(checkingCondition);
    }

    //TODO: IMPLEMENT LOGIC OF CONDITION CHANGE
    public void changeContractCondition(Condition conditionFrom, Condition conditionTo){

    }

    //TODO: CAN BE MOVED TO SEPARATE CLASS
    private boolean canCreateConditionPolicy(Condition condition) {
        switch (condition.getConditionType()) {
            case RECEIPT:
                return !this.conditions.contains(new Condition(ConditionType.SPECIAL_CONDITION, condition.getConditionItems(), condition.getContractDuration()));
            case SPECIAL_CONDITION:
                return !this.conditions.contains(new Condition(ConditionType.RECEIPT, condition.getConditionItems(), condition.getContractDuration()));
        }
        return true;
    }
}
