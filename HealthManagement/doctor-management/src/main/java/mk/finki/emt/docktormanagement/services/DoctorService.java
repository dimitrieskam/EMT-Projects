package mk.finki.emt.docktormanagement.services;

import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.docktormanagement.domain.model.DoctorId;
import mk.finki.emt.docktormanagement.domain.valueobjects.Patient;
import mk.finki.emt.docktormanagement.services.forms.DoctorForm;

import java.util.List;

public interface DoctorService {
    Doctor findById(DoctorId id);
    Doctor addDoctor(DoctorForm form);
    Doctor scheduleAppointmentAdded(DoctorId doctorId, Patient patient);
    Doctor scheduleAppointmentCanceled(DoctorId doctorId, Patient patient);
    List<Doctor> getAll();

}
