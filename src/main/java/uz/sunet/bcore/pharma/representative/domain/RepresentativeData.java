package uz.sunet.bcore.pharma.representative.domain;

import org.springframework.util.Assert;
import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class RepresentativeData {

    private AggregateId representativeId;

    public RepresentativeData(AggregateId representativeId) {
        Assert.notNull(representativeId);
        this.representativeId = representativeId;
    }

    public AggregateId getRepresentativeData() {
        return representativeId;
    }
}
