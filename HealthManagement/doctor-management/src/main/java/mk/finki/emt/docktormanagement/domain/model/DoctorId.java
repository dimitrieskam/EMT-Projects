package mk.finki.emt.docktormanagement.domain.model;

import mk.finki.emt.patientmanagement.domain.models.PatientId;
import mk.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

import javax.print.Doc;

public class DoctorId extends DomainObjectId {
    private DoctorId(){
        super(PatientId.randomId(PatientId.class).getId());
    }

    public DoctorId(@NonNull String uuid){
        super(uuid);
    }
    public static DoctorId of(String uuid){
        DoctorId p=new DoctorId(uuid);
        return p;
    }
}
