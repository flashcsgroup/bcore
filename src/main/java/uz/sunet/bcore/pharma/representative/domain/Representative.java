package uz.sunet.bcore.pharma.representative.domain;

import uz.sunet.bcore.ddd.annotations.domain.AggregateRoot;
import uz.sunet.bcore.ddd.support.domain.BaseAggregateRoot;
import uz.sunet.bcore.pharma.marketing.domain.doctor.Age;
import uz.sunet.bcore.pharma.marketing.domain.doctor.Doctor;
import uz.sunet.bcore.pharma.marketing.domain.doctor.FullName;
import uz.sunet.bcore.pharma.marketing.domain.medication.MedicationGroup;
import uz.sunet.bcore.pharma.sharedkernel.Address.Address;
import uz.sunet.bcore.pharma.sharedkernel.Address.Region;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */

@Entity
@AggregateRoot
public class Representative extends BaseAggregateRoot{
    private FullName fullName;
    private Age age;
    private Address address;
    private Region region;
    private MedicationGroup medicationGroup;
    private Set<Doctor> attachedDoctors = HashSet<Doctor>();

}
