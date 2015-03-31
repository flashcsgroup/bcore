package uz.sunet.bcore.pharma.marketing.infrastructure.repository.implementation;

import uz.sunet.bcore.ddd.annotations.domain.DomainRepositoryImpl;
import uz.sunet.bcore.ddd.support.infrastructure.repository.jpa.GenericJpaRepository;
import uz.sunet.bcore.pharma.marketing.domain.medication.Medication;
import uz.sunet.bcore.pharma.marketing.domain.medication.MedicationRepository;

/**
 * @author Jasurbek Khajiev
 */
@DomainRepositoryImpl
public class JpaMedicationRepository extends GenericJpaRepository<Medication> implements MedicationRepository {

}
