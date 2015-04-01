package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Position {
    @Embedded
    private String positionName;
    @Embedded
    private String department;

    public Position(String positionName, String department) {
        this.positionName = positionName;
        this.department = department;
    }

    public String getPositionName() {
        return positionName;
    }

    public String getDepartment() {
        return department;
    }

    //CREATED FOR JPA TO WORK PROPERLY

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

