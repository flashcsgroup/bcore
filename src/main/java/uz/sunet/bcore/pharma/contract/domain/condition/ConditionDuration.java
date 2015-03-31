package uz.sunet.bcore.pharma.contract.domain.condition;

import java.util.Date;

/**
 * @author Jasurbek Khajiev
 */
@uz.sunet.bcore.ddd.annotations.domain.ValueObject
public class ConditionDuration {
    private Date startDate;
    private Date endDate;

    public ConditionDuration(Date startDate, Date endDate) throws Exception {
        if (startDate != null)
            this.startDate = startDate;
        else throw new IllegalArgumentException("Start date is not set");
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
