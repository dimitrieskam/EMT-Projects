package mk.finki.emt.patientmanagement.domain.models;
import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import mk.finki.emt.docktormanagement.domain.valueobjects.ExaminationType;
import mk.finki.emt.docktormanagement.domain.valueobjects.Specialization;
import mk.finki.emt.docktormanagement.domain.valueobjects.WorkTime;
import mk.finki.emt.patientmanagement.domain.converter.DiseaseHistoryConverter;
import mk.finki.emt.patientmanagement.domain.valueobjects.DiseaseHistory;
import mk.finki.emt.patientmanagement.domain.valueobjects.DoctorId;
import mk.finki.emt.patientmanagement.domain.valueobjects.SSN;
import mk.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.emt.sharedkernel.domain.contact.EmailAddress;
import mk.finki.emt.sharedkernel.domain.contact.PhoneNumber;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

public class Patient extends AbstractEntity<PatientId>{
    private String PatientName;
    private String PatientSurname;
    private SSN ssn;
    private PhoneNumber PhoneNumber;
    private EmailAddress EmailAddress;

   @Convert(converter = DiseaseHistoryConverter.class)
    private DiseaseHistory diseaseHistory;
    @ElementCollection
    private Set<DoctorId> doctorIds = new HashSet<>();

    public static Patient build(String PatientName, String PatientSurname, SSN ssn, PhoneNumber PhoneNumber, EmailAddress EmailAddress, DiseaseHistory diseaseHistory) {
        Patient patient = new Patient();
        patient.PatientName=PatientName;
        patient.PatientSurname=PatientSurname;
        patient.ssn=ssn;
        patient.PhoneNumber=PhoneNumber;
        patient.EmailAddress=EmailAddress;
        patient.diseaseHistory=diseaseHistory;
        return patient;
    }
    public void addDoctorToSchedule(@NonNull DoctorId doctorId) {
        Objects.requireNonNull(doctorId, "DoctorId must not be null");
        doctorIds.add(doctorId);
    }
    public void removeDoctorFromSchedule(@NonNull DoctorId doctorId){
        Objects.requireNonNull(doctorId, "DoctorId must not be null");
        doctorIds.remove(doctorIds);
    }
}
