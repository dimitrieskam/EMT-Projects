package mk.finki.emt.patientmanagement.domain.models;

import org.springframework.lang.NonNull;


import mk.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class PatientId extends DomainObjectId {
    private PatientId(){
        super(PatientId.randomId(PatientId.class).getId());
    }

    public PatientId(@NonNull String uuid){
        super(uuid);
    }
    public static PatientId of(String uuid){
        PatientId p=new PatientId(uuid);
        return p;
    }
}
