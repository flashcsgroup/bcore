package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Position {
    private String positionName;
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
}

