package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Point {
    //TODO CHANGE STUFF HERE
    //public static final Point ZERO = new Point();
    @Transient
    private BigDecimal denomination;

    public Point(BigDecimal denomination) {
        this.denomination = denomination;
    }

//    public static Point getZero() {
//        return ZERO;
//    }

    public BigDecimal getDenomination() {
        return denomination;
    }
}
