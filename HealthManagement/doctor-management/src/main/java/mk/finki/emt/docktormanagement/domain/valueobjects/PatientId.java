package mk.finki.emt.docktormanagement.domain.valueobjects;

import mk.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class PatientId extends DomainObjectId {
    private PatientId(){
        super(PatientId.randomId(PatientId.class).getId());
    }
    public PatientId(String uuid){
        super(uuid);
    }
}
