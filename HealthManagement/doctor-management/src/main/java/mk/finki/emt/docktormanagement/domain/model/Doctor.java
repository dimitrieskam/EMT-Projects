package mk.finki.emt.docktormanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.finki.emt.docktormanagement.domain.valueobjects.*;
import mk.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.finki.emt.sharedkernel.domain.contact.EmailAddress;
import mk.finki.emt.sharedkernel.domain.contact.PhoneNumber;
import org.springframework.lang.NonNull;

import javax.print.Doc;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
public class Doctor extends AbstractEntity<DoctorId> {
   @Column(nullable = false)
    private String DoctorName;
    @Column(nullable = false)
    private String DoctorSurname;
    @Embedded
    private Specialization specialization;
    @Embedded
    private WorkTime workTime;
    @Enumerated(EnumType.STRING)
    private ExaminationType examinationType;
    @Embedded
    private PhoneNumber PhoneNumber;
    @Embedded
    private EmailAddress EmailAddress;
    private Double Rating;
 @ElementCollection
 private Set<PatientId> patientIds = new HashSet<>();

 public static Doctor build(String DoctorName, String DoctorSurname, Specialization specialization, WorkTime workTime, ExaminationType examinationType, PhoneNumber PhoneNumber, EmailAddress EmailAddress, Double rating) {
  Doctor doctor = new Doctor();
  doctor.DoctorName = DoctorName;
  doctor.DoctorSurname = DoctorSurname;
  doctor.specialization = specialization;
  doctor.workTime = workTime;
  doctor.examinationType = examinationType;
  doctor.PhoneNumber = PhoneNumber;
  doctor.EmailAddress = EmailAddress;
  doctor.Rating = rating;
  return doctor;
 }

 public void addPatientToSchedule(@NonNull PatientId patientId) {
  Objects.requireNonNull(patientId, "PatientId must not be null");
  patientIds.add(patientId);
 }
 public void removePatientFromSchedule(@NonNull PatientId patientId){
  Objects.requireNonNull(patientId, "PatientId must not be null");
patientIds.remove(patientId);
 }


}
