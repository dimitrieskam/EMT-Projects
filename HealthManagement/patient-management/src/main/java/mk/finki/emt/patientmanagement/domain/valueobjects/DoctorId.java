package mk.finki.emt.patientmanagement.domain.valueobjects;

import mk.finki.emt.docktormanagement.domain.valueobjects.PatientId;
import mk.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class DoctorId extends DomainObjectId {
    private DoctorId(){
        super(DoctorId.randomId(DoctorId.class).getId());
    }
    public DoctorId(String uuid){
        super(uuid);
    }
}
