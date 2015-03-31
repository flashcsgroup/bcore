package uz.sunet.bcore.pharma.contract.domain;

import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

import java.util.List;

/**
 * @author Jasurbek Khajiev
 */
public interface ContractRepository {
    public Contract GetContract(AggregateId contractId);

    public void SaveContract(Contract contract);

    public List<Contract> GetContractsByRepresentativeId(AggregateId representativeId);

    public List<Contract> GetContractsByDoctorId(AggregateId doctorId);

}
