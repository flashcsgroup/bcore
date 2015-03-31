package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;
import uz.sunet.bcore.pharma.sharedkernel.Money;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Performance {
    private Double pointsEarned;
    private String giftDesired;
    private Money giftPrice;
    private Double completion;

    public Performance(Double pointsEarned, String giftDesired, Money giftPrice, Double completion) {
        this.pointsEarned = pointsEarned;
        this.giftDesired = giftDesired;
        this.giftPrice = giftPrice;
        this.completion = completion;
    }

    public Double getPointsEarned() {
        return pointsEarned;
    }

    public String getGiftDesired() {
        return giftDesired;
    }

    public Money getGiftPrice() {
        return giftPrice;
    }

    public Double getCompletion() {
        return completion;
    }
}
