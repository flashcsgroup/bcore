package uz.sunet.bcore.ddd.sagas;


import uz.sunet.bcore.ddd.annotations.event.Event;

import java.io.Serializable;

@Event
public class AnotherDomainEvent implements Serializable {
    private final Long aggregateId;
    private final String data;

    public AnotherDomainEvent(Long aggregateId, String data) {
        this.aggregateId = aggregateId;
        this.data = data;
    }

    public Long getAggregateId() {
        return aggregateId;
    }

    public String getData() {
        return data;
    }
}
