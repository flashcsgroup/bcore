package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.canonicalmodel.publishedlanguage.AggregateId;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Promotion {
    private AggregateId promotionId;
    private String promotionName;

    public Promotion(AggregateId promotionId, String promotionName) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
    }

    public AggregateId getPromotionId() {
        return promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (!promotionId.equals(promotion.promotionId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return promotionId.hashCode();
    }
}
