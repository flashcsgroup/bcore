package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.DomainFactory;
import uz.sunet.bcore.pharma.sharedkernel.Address.Address;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jasurbek Khajiev
 */
@DomainFactory
public class DoctorFactory {

    public Doctor create(String name,String lastName,String middleName, Date dob,List<Specialization> specializations, Contacts contacts, String position, String departmentName,Category category, Loyalty loyalty,String nameOfPlace, Address address, String workPlacePhone, String workPlaceFax){
        Doctor doctor = new Doctor();
        doctor.setFullName(createFullName(name,lastName,middleName));
        doctor.setAge(new Age(dob));
        Set<Specialization> specializationsSet = new HashSet<>();
        specializationsSet.addAll(specializations);
        doctor.setSpecializations(specializationsSet);
        doctor.setWorkPlace(createWorkPlace(nameOfPlace,address,workPlacePhone, workPlaceFax));
        doctor.setPosition(createPosition(position,departmentName));
        doctor.setContacts(contacts);
        doctor.setCategory(category);
        doctor.setLoyalty(loyalty);
        doctor.setCooperationStartDate(new Date());
        return doctor;
    }

    private FullName createFullName(String name, String lastName, String middleName){
        return new FullName(name,lastName,middleName);
    }

    public Contacts createContacts(List<String> phoneNumber,String email,String fax){
        return new Contacts(phoneNumber,email, fax);
    }

    private Position createPosition(String positionName, String departmentName){
        return new Position(positionName,departmentName);
    }

    private WorkPlace createWorkPlace(String nameOfPlace,Address address,String phoneNumber, String fax){
        return new WorkPlace(nameOfPlace,address,phoneNumber,fax);
    }

}
