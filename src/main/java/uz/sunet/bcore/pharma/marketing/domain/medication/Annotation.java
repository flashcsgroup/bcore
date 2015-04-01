package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

import javax.persistence.Embeddable;

/**
 * @author Jasurbek Khajiev
 */
@Embeddable
@ValueObject
public class Annotation {
    private String description;
    private String consist;

    public Annotation(String description, String consist) {
        this.description = description;
        this.consist = consist;
    }

    public Annotation() {
    }

    public String getDescription() {
        return description;
    }

    public String getConsist() {
        return consist;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConsist(String consist) {
        this.consist = consist;
    }
}
