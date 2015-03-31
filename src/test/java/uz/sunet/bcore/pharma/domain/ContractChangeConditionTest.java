package uz.sunet.bcore.pharma.domain;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/sagasIntegrationTestContext.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
/**
 * This class is created to check proper contract condition changing algorithm
 * @author Jasurbek Khajiev
 */

public class ContractChangeConditionTest {
/*
    @Test
    public void changeContractConditionFromReceiptToSpecialCondition() throws Exception {
        //given
        AggregateId representativeId = AggregateId.generate();
        AggregateId doctorId = AggregateId.generate();
        AggregateId pharmacyId = AggregateId.generate();
        AggregateId medicationId = AggregateId.generate();
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        HashMap<AggregateId, Integer> medicationsWithAmount = new HashMap<AggregateId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(AggregateId.generate(), (i + 50));
        }
        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialCondition = ContractFactory.createSpecialConditionContractCondition(medicationsWithAmount, pharmacyId, conditionDuration);
        contract.addNewCondition(receiptCondition);

        //when
        contract.changeContractCondition(receiptCondition, specialCondition);

        //then
        Assert.assertTrue(contract.getConditions().contains(specialCondition));
        Assert.assertFalse(contract.getConditions().contains(receiptCondition));
    }

    @Test
    public void changeContractConditionFromReceiptToSpecialPoint() throws Exception{
        //given
        AggregateId representativeId = AggregateId.generate();
        AggregateId doctorId = AggregateId.generate();
        AggregateId pharmacyId = AggregateId.generate();
        AggregateId medicationId = AggregateId.generate();
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        Integer amount = 100;
        Double percent = 20.0;
        HashMap<AggregateId, Integer> medicationsWithAmount = new HashMap<AggregateId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(AggregateId.generate(), (i + 50));
        }
        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialPoint = ContractFactory.createSpecialPointContractCondition(medicationId, amount, percent, pharmacyId, conditionDuration);
        contract.addNewCondition(receiptCondition);

        //when
        contract.changeContractCondition(receiptCondition, specialPoint);

        //then
        Assert.assertTrue(contract.getConditions().contains(specialPoint));
        Assert.assertFalse(contract.getConditions().contains(receiptCondition));
    }

    @Test
    public void changeContractConditionFromSpecialConditionToSpecialPoint() throws Exception{
        //given
        RepresentativeId representativeId = new RepresentativeId((long) 1);
        DoctorId doctorId = new DoctorId((long) 2);
        PharmacyId pharmacyId = new PharmacyId((long) 3);
        MedicationId medicationId = new MedicationId((long) 4);
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        Integer amount = 100;
        Double percent = 20.0;
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        HashMap<MedicationId, Integer> medicationsWithAmount = new HashMap<MedicationId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(new MedicationId((long) (i + 10)), (i + 50));
        }
        Condition specialPointCondition = ContractFactory.createSpecialPointContractCondition(medicationId, amount, percent, pharmacyId, conditionDuration);
        Condition specialCondition = ContractFactory.createSpecialConditionContractCondition(medicationsWithAmount, pharmacyId, conditionDuration);
        contract.addNewCondition(specialCondition);

        //when
        contract.changeContractCondition(specialCondition, specialPointCondition);

        //then
        Assert.assertTrue(contract.getConditions().contains(specialPointCondition));
        Assert.assertFalse(contract.getConditions().contains(specialCondition));
    }

    @Test
    public void changeContractConditionFromSpecialPointToSpecialCondition() throws Exception{
        //given
        RepresentativeId representativeId = new RepresentativeId((long) 1);
        DoctorId doctorId = new DoctorId((long) 2);
        PharmacyId pharmacyId = new PharmacyId((long) 3);
        MedicationId medicationId = new MedicationId((long) 4);
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        Integer amount = 100;
        Double percent = 20.0;
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        HashMap<MedicationId, Integer> medicationsWithAmount = new HashMap<MedicationId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(new MedicationId((long) (i + 10)), (i + 50));
        }
        Condition specialPointCondition = ContractFactory.createSpecialPointContractCondition(medicationId, amount, percent, pharmacyId, conditionDuration);
        Condition specialCondition = ContractFactory.createSpecialConditionContractCondition(medicationsWithAmount, pharmacyId, conditionDuration);
        contract.addNewCondition(specialPointCondition);

        //when
        contract.changeContractCondition(specialPointCondition, specialCondition);

        //then
        Assert.assertTrue(contract.getConditions().contains(specialCondition));
        Assert.assertFalse(contract.getConditions().contains(specialPointCondition));
    }

    @Test
    public void changeContractConditionFromSpecialPointToReceipt() throws Exception{
        //given
        RepresentativeId representativeId = new RepresentativeId((long) 1);
        DoctorId doctorId = new DoctorId((long) 2);
        PharmacyId pharmacyId = new PharmacyId((long) 3);
        MedicationId medicationId = new MedicationId((long) 4);
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        Integer amount = 100;
        Double percent = 20.0;
        HashMap<MedicationId, Integer> medicationsWithAmount = new HashMap<MedicationId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(new MedicationId((long) (i + 10)), (i + 50));
        }
        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialPoint = ContractFactory.createSpecialPointContractCondition(medicationId, amount, percent, pharmacyId, conditionDuration);
        contract.addNewCondition(specialPoint);

        //when
        contract.changeContractCondition(specialPoint, receiptCondition);

        //then
        Assert.assertTrue(contract.getConditions().contains(receiptCondition));
        Assert.assertFalse(contract.getConditions().contains(specialPoint));
    }

    @Test
    public void changeContractConditionFromSpecialConditionToReceipt() throws Exception{
        //given
        RepresentativeId representativeId = new RepresentativeId((long) 1);
        DoctorId doctorId = new DoctorId((long) 2);
        PharmacyId pharmacyId = new PharmacyId((long) 3);
        MedicationId medicationId = new MedicationId((long) 4);
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        HashMap<MedicationId, Integer> medicationsWithAmount = new HashMap<MedicationId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(new MedicationId((long) (i + 10)), (i + 50));
        }
        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialCondition = ContractFactory.createSpecialConditionContractCondition(medicationsWithAmount, pharmacyId, conditionDuration);
        contract.addNewCondition(specialCondition);

        //when
        contract.changeContractCondition(specialCondition, receiptCondition);

        //then
        Assert.assertTrue(contract.getConditions().contains(receiptCondition));
        Assert.assertFalse(contract.getConditions().contains(specialCondition));
    }

    //this test is created to check if it cannot be changed to special point condition with existing medication pharmacy relationship
    @Test
    public void changeContractConditionFromSpecialConditionToSpecialPointWithExistingPharmacyMedicationRecord() throws Exception{
        //given
        RepresentativeId representativeId = new RepresentativeId((long) 1);
        DoctorId doctorId = new DoctorId((long) 2);
        DoctorId doctorId2 = new DoctorId((long) 2);
        PharmacyId pharmacyId = new PharmacyId((long) 3);
        MedicationId medicationId = new MedicationId((long) 4);
        Contract contract = ContractFactory.createContract(representativeId, doctorId);
        Contract contract2 = ContractFactory.createContract(representativeId, doctorId2);
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        Integer amount = 100;
        Double percent = 20.0;
        Integer amount2 = 200;
        Double percent2 = 18.0;
        HashMap<MedicationId, Integer> medicationsWithAmount = new HashMap<MedicationId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(new MedicationId((long) (i + 10)), (i + 50));
        }
        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialPoint = ContractFactory.createSpecialPointContractCondition(medicationId, amount, percent, pharmacyId, conditionDuration);
        Condition specialPoint2 = ContractFactory.createSpecialPointContractCondition(medicationId, amount2, percent2, pharmacyId, conditionDuration);


        //when
        contract.addNewCondition(receiptCondition);
        contract2.addNewCondition(specialPoint2);
        contract.changeContractCondition(receiptCondition, specialPoint);

        //then
        Assert.assertTrue(contract2.getConditions().contains(specialPoint2));
        Assert.assertTrue(contract.getConditions().contains(receiptCondition));
        Assert.assertFalse(contract.getConditions().contains(specialPoint));
    }
    */
}

