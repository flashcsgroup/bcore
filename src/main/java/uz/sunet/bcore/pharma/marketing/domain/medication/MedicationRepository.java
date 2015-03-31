package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.DomainRepository;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@DomainRepository
public interface MedicationRepository {
    public Medication load(AggregateId medicationId);

    public void save(Medication medication);
}
