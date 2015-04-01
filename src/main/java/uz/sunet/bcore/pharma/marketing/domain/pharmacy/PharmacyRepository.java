package uz.sunet.bcore.pharma.marketing.domain.pharmacy;

import uz.sunet.bcore.ddd.annotations.domain.DomainRepository;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jonik Negmatov
 */
@DomainRepository
public interface PharmacyRepository {
    public Pharmacy load(AggregateId pharmacyID);

    public void save(Pharmacy pharmacy);

}
