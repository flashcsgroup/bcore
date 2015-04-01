package uz.sunet.bcore.pharma.marketing.domain.doctor;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Position {
    private String positionName;
    private String department;

    public Position() {
    }

    public Position(String positionName, String department) {
        this.positionName = positionName;
        this.department = department;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

