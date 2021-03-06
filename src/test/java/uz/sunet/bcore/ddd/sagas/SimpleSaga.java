package uz.sunet.bcore.ddd.sagas;

import uz.sunet.bcore.pharma.system.saga.SagaInstance;
import uz.sunet.bcore.pharma.system.saga.annotations.Saga;
import uz.sunet.bcore.pharma.system.saga.annotations.SagaAction;

import javax.inject.Inject;

@Saga
public class SimpleSaga extends SagaInstance<SimpleSagaData> {

    private final SagaSpy spy;

    @Inject
    public SimpleSaga(SagaSpy spy) {
        this.spy = spy;
    }

    @SagaAction
    public void onSampleDomainEvent(SampleDomainEvent event) {
        data.setAggregateId(event.getAggregateId());
        spy.sampleEventHandled();
        completeIfPossible();
    }

    @SagaAction
    public void onAnotherDomainEvent(AnotherDomainEvent event) {
        data.setData(event.getData());
        spy.anotherEventHandled();
        completeIfPossible();
    }

    private void completeIfPossible() {
        if (data.getAggregateId() != null && data.getData() != null) {
            spy.sagaCompleted();
            markAsCompleted();
        }
    }
}
