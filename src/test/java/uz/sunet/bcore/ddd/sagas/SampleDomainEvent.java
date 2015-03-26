package uz.sunet.bcore.ddd.sagas;


import uz.sunet.bcore.ddd.annotations.event.Event;

import java.io.Serializable;
import java.lang.annotation.Annotation;

@Event
public class SampleDomainEvent implements Serializable {

    private final Long aggregateId;

    public SampleDomainEvent(Long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public Long getAggregateId() {
        return aggregateId;
    }

}
