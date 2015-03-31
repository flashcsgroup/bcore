package uz.sunet.bcore.pharma.marketing.domain.medication;

import uz.sunet.bcore.ddd.annotations.domain.ValueObject;

/**
 * @author Jasurbek Khajiev
 */
@ValueObject
public class Annotation {
    private String description;
    private String consist;

    public Annotation(String description, String consist) {
        this.description = description;
        this.consist = consist;
    }

    public String getDescription() {
        return description;
    }

    public String getConsist() {
        return consist;
    }
}