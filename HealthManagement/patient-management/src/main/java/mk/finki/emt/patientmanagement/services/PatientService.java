package mk.finki.emt.patientmanagement.services;

import mk.finki.emt.patientmanagement.domain.models.Patient;
import mk.finki.emt.patientmanagement.domain.models.PatientId;
import mk.finki.emt.patientmanagement.domain.valueobjects.Doctor;
import mk.finki.emt.patientmanagement.services.forms.PatientForm;

import java.util.List;

public interface PatientService {
    mk.finki.emt.patientmanagement.domain.models.Patient findById(PatientId id);
   mk.finki.emt.patientmanagement.domain.models.Patient addPatient(PatientForm form);
    Patient scheduleAppointmentAdded(PatientId patientId, Doctor doctor);
    Patient scheduleAppointmentCanceled(PatientId patientId, Doctor doctor);
    List<Patient> getAll();
}
