package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import java.math.BigDecimal;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Point {
    //TODO CHANGE STUFF HERE
    //public static final Point ZERO = new Point();
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
