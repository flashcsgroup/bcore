package uz.sunet.bcore.pharma.marketing.infrastructure.repository.implementation;

import uz.sunet.bcore.ddd.annotations.domain.DomainRepositoryImpl;
import uz.sunet.bcore.ddd.support.infrastructure.repository.jpa.GenericJpaRepository;
import uz.sunet.bcore.pharma.marketing.domain.doctor.Doctor;
import uz.sunet.bcore.pharma.marketing.domain.doctor.DoctorRepository;

/**
 * @author Jasurbek Khajiev
 */
@DomainRepositoryImpl
public class JpaDoctorRepository extends GenericJpaRepository<Doctor> implements DoctorRepository {

    //TODO ASK ABOUT THIS IMPLEMENTATION
    /*
    public void save(Doctor doctor){}

    public Doctor load(AggregateId doctorId){return null;}
*/

}
