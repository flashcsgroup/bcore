package uz.sunet.bcore.pharma.domain;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;
import uz.sunet.bcore.pharma.contract.domain.Contract;
import uz.sunet.bcore.pharma.contract.domain.ContractFactory;
import uz.sunet.bcore.pharma.contract.domain.condition.Condition;
import uz.sunet.bcore.pharma.contract.domain.condition.ConditionDuration;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * This class is created to check proper contract creating algorithm
 * @author Jasurbek Khajiev
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/sagasIntegrationTestContext.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class ContractCreationTest {

    @Test
    public void isNewContractCreated() throws Exception {
        /*CODE TO BE RECONSIDERED*/
        //Contract contract = contractFactory.createContract(representativeID, conditions, doctorID);
        //Representative representative = representativeRepository.getRepresentativeByID(1);
        //int doctorID=1;
        //Integer contractID = representative.createContract(doctorID, conditions);
        //Representative representative = new Representative(1);
        //Doctor domain = new Doctor(2);

        //GIVEN
        //TODO: INSTANTIATE VARIABLES (wrongRepresentativeID,wrongDoctorID) OF THIS TEST AFTER REPOSITORY CREATION AND RUN ONCE AGAIN, CHANGE NULL VALUES TO WRONG(NON-EXISTING) VALUES

        AggregateId representativeID, wrongRepresentativeID;
        AggregateId doctorID, wrongDoctorID;
        //WHEN
        representativeID = AggregateId.generate();
        doctorID = AggregateId.generate();
        //THEN


        //Creating contract for the domain with condition receipt, and checking if it does not create with condition specialConditions
        //Creating contract for the empty Contract Condition to see if it is null
        assertNull(ContractFactory.createContract(representativeID, null));
        assertNull(ContractFactory.createContract(null, doctorID));
        assertNull(ContractFactory.createContract(null, null));
        assertNotNull(ContractFactory.createContract(representativeID, doctorID));
    }

    @Test
    public void isNewDoubleContractCreatedReceipt() throws Exception {
        /*CODE TO BE RECONSIDERED*/
        //Contract contract = contractFactory.createContract(representativeID, conditions, doctorID);
        //Representative representative = representativeRepository.getRepresentativeByID(1);
        //int doctorID=1;
        //Integer contractID = representative.createContract(doctorID, conditions);
        //Representative representative = new Representative(1);
        //Doctor domain = new Doctor(2);

        //given
        AggregateId representativeID = AggregateId.generate();
        AggregateId doctorID = AggregateId.generate();
        AggregateId pharmacyId = AggregateId.generate();
        AggregateId medicationId = AggregateId.generate();
        Contract contract = ContractFactory.createContract(representativeID, doctorID);
        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        HashMap<AggregateId, Integer> medicationsWithAmount = new HashMap<AggregateId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(AggregateId.generate(), (i + 50));
        }

        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialCondition = ContractFactory.createSpecialConditionContractCondition(medicationsWithAmount, pharmacyId, conditionDuration);
        Condition specialMedicationConditions = ContractFactory.createSpecialPointContractCondition(medicationId, 200, 20.0, pharmacyId, conditionDuration);

        //when
        contract.addNewCondition(receiptCondition);
        try {
            contract.addNewCondition(specialCondition);
        } catch (Exception e) {

        }

        contract.addNewCondition(specialMedicationConditions);

        //then
        Assert.assertTrue(contract.getConditions().contains(receiptCondition));
        Assert.assertTrue(contract.getConditions().contains(specialMedicationConditions));
        Assert.assertFalse(contract.getConditions().contains(specialCondition));

        //Creating contract for the domain with condition receipt, and checking if it does not create with condition specialConditions
//        HashSet<Condition> conditions = new HashSet<Condition>();
//        conditions.add(receiptCondition);
//        conditions.add(specialCondition);
//        conditions.add(specialMedicationConditions);
//        ContractFactory.createContractCondition(contract,conditions);

    }

    @Test
    public void isNewDoubleContractCreatedSpecialConditions() throws Exception {
        /*CODE TO BE RECONSIDERED*/
        //Contract contract = contractFactory.createContract(representativeID, conditions, doctorID);
        //Representative representative = representativeRepository.getRepresentativeByID(1);
        //int doctorID=1;
        //Integer contractID = representative.createContract(doctorID, conditions);
        //Representative representative = new Representative(1);
        //Doctor domain = new Doctor(2);

        //given
        AggregateId representativeID = AggregateId.generate();
        AggregateId doctorID = AggregateId.generate();
        AggregateId pharmacyId =AggregateId.generate();
        AggregateId medicationId = AggregateId.generate();
        Contract contract = ContractFactory.createContract(representativeID, doctorID);

        ConditionDuration conditionDuration = new ConditionDuration(new Date(), new Date());
        HashMap<AggregateId, Integer> medicationsWithAmount = new HashMap<AggregateId, Integer>();
        for (int i = 0; i < 6; i++) {
            medicationsWithAmount.put(AggregateId.generate(), (i + 50));
        }
        Condition receiptCondition = ContractFactory.createReceiptContractCondition(medicationsWithAmount, conditionDuration);
        Condition specialCondition = ContractFactory.createSpecialConditionContractCondition(medicationsWithAmount, pharmacyId, conditionDuration);
        Condition specialMedicationConditions = ContractFactory.createSpecialPointContractCondition(medicationId, 200, 20.0, pharmacyId, conditionDuration);

        //when
        contract.addNewCondition(specialCondition);

        try {
            contract.addNewCondition(receiptCondition);
        } catch (Exception e) {

        }

        contract.addNewCondition(specialMedicationConditions);

        //then
        Assert.assertTrue(contract.getConditions().contains(specialCondition));
        Assert.assertTrue(contract.getConditions().contains(specialMedicationConditions));
        Assert.assertFalse(contract.getConditions().contains(receiptCondition));
    }

}

