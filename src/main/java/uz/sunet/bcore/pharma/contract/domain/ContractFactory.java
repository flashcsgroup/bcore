package uz.sunet.bcore.pharma.contract.domain;

import org.springframework.util.Assert;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;
import uz.sunet.bcore.pharma.contract.domain.condition.*;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Jasurbek Khajiev
 */

/**
 * Factory class for contract aggregate root
 */
public class ContractFactory {

    //TODO IMPLEMENT CREATION OF CONTRACT!!!!!

    public static Contract createContract(AggregateId representativeId, AggregateId doctorId) {
        Contract contract = new Contract();
        contract.setAggregateId(AggregateId.generate());

//        Needs to be considered
//        contract.setConditions(createContractCondition());

        if (representativeId == null) return null;
        contract.setRepresentativeId(representativeId);
        if (doctorId == null) return null;
        contract.setDoctorId(doctorId);
        return contract;
    }

//    public static Condition createContractCondition(ContractId contractId)
//    {
//        ConditionManager conditionManager = new ConditionManager();
//        conditionManager.setContractId(contractId);
//        return conditionManager;
//    }

    public static Contract createContractCondition(Contract contract, Condition condition) {
        ConditionManager conditionManager = new ConditionManager();
        Assert.notNull(contract);
        Assert.notNull(condition);
        try {
            conditionManager.addCondition(contract, condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }

    public static Contract createContractCondition(Contract contract, HashSet<Condition> conditions) {
        ConditionManager conditionManager = new ConditionManager();
        Assert.notNull(contract);
        Assert.notNull(conditions);
        try {
            conditionManager.addConditions(contract, conditions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }


  /*  public static Contract createContract(RepresentativeId representativeId, DoctorId doctorId, ConditionManager condition){
        Contract contract = new Contract();
        contract.setRepresentativeId(representativeId);
        contract.setConditions(condition);
        contract.setDoctorId(doctorId);
        return contract;
    }
*/

    public static Condition createReceiptContractCondition(HashMap<AggregateId, Integer> medicationWithAmount, ConditionDuration conditionDuration) throws Exception {


        Assert.notNull(medicationWithAmount);
        HashSet<ConditionItem> conditionItems = new HashSet<ConditionItem>();
        for (AggregateId medicationId : medicationWithAmount.keySet()) {
            ConditionItem conditionItem = new ConditionItem();
            conditionItem.setMedicationId(medicationId);
            conditionItem.setAmount(medicationWithAmount.get(medicationId));
            conditionItems.add(conditionItem);
        }
        //Condition condition = new Condition(ConditionType.RECEIPT, conditionItems, conditionDuration); return condition;
        return new Condition(ConditionType.RECEIPT, conditionItems, conditionDuration);
    }

    public static Condition createSpecialPointContractCondition(AggregateId medicationId, Integer amount, Double commission, AggregateId pharmacyId, ConditionDuration conditionDuration) {
        ConditionItem conditionItem = new ConditionItem();
        Assert.notNull(medicationId);
        conditionItem.setMedicationId(medicationId);
        Assert.notNull(commission);
        conditionItem.setPercent(commission);
        Assert.notNull(amount);
        conditionItem.setAmount(amount);
        Assert.notNull(pharmacyId);
        conditionItem.setPharmacyId(pharmacyId);
        HashSet<ConditionItem> conditionItems = new HashSet<ConditionItem>();
        conditionItems.add(conditionItem);
        Assert.notNull(conditionDuration);
        //Condition condition = new Condition(ConditionType.SPECIAL_POINTS, conditionItems, conditionDuration);
        return new Condition(ConditionType.SPECIAL_POINTS, conditionItems, conditionDuration);
    }

    public static Condition createSpecialConditionContractCondition(HashMap<AggregateId, Integer> medicationWithAmount, AggregateId pharmacyId, ConditionDuration conditionDuration) {
        Assert.notNull(medicationWithAmount);
        HashSet<ConditionItem> conditionItems = new HashSet<ConditionItem>();
        Assert.notNull(pharmacyId);
        for (AggregateId medicationId : medicationWithAmount.keySet()) {
            ConditionItem conditionItem = new ConditionItem();
            conditionItem.setMedicationId(medicationId);
            conditionItem.setAmount(medicationWithAmount.get(medicationId));
            conditionItem.setPharmacyId(pharmacyId);
            conditionItems.add(conditionItem);
        }
        ConditionAdditionPolicyImplementation conditionAdditionPolicyImplementation = new ConditionAdditionPolicyImplementation();
        Assert.notNull(conditionDuration);
        Condition condition = new Condition(ConditionType.SPECIAL_CONDITION, conditionItems, conditionDuration);
        if (!conditionAdditionPolicyImplementation.canCreateSpecialCondition(condition))
            throw new IllegalArgumentException("Cannot create special condition, too few medications");
        return condition;
    }
    /**
     *
     * @return
     *//*
    public static Contract createContractWithReceiptCondition(){
       //TOD/O: retseptura bo'yicha logika kiriting
        return null;
    }

    public static Contract createContractWithSpecialConditions(RepresentativeId representativeId, DoctorId doctorId){
        return createContract(representativeId, doctorId, null);
    }

    public static Contract createContractWithSpecialPoints(RepresentativeId representativeId, DoctorId doctorId) {

    }
*/




  /*  public static Contract createContract(AggregateId representativeID ,SpecialPoints specialPoints, AggregateId doctorID){
        Contract contract = new Contract();
        contract.setRepresentativeId(representativeID);
        contract.setConditions(condition);
        contract.setDoctorId(doctorID);
        return contract;
    }*/

/*        public static List<ConditionManager> createContractCondition
        (List <AggregateId> medicationIds, List < Integer > amounts)throws Exception {
            ConditionManager receiptCondition = new ReceiptCondition(medicationIds, amounts);
            return receiptCondition;
        }

    public static ConditionManager createContractCondition(List<AggregateId> medicationIds,List<Integer> amounts,AggregateId pharmacyId) throws Exception{
        ConditionManager specialCondition = new SpecialCondition(medicationIds, amounts, pharmacyId);
        return specialCondition;
    }

    public static ConditionManager createContractCondition(List<AggregateId> medicationIds,List<Integer> amounts,AggregateId pharmacyId, List<Double> percentages) throws Exception{
        ConditionManager specialPoints = new SpecialPoints(medicationIds,amounts, pharmacyId,percentages);
        return specialPoints;
    }*/
}
