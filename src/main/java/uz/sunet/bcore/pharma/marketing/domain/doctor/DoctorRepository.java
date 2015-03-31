package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.DomainRepository;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@DomainRepository
public interface DoctorRepository {

    public Doctor load(AggregateId doctorId);

    public void save(Doctor doctor);

}
