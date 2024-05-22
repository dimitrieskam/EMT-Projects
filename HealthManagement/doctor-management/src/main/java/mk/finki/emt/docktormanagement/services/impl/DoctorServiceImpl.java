package mk.finki.emt.docktormanagement.services.impl;

import mk.finki.emt.docktormanagement.domain.exceptions.DoctorNotFoundException;
import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.docktormanagement.domain.model.DoctorId;
import mk.finki.emt.docktormanagement.domain.repository.DoctorRepository;
import mk.finki.emt.docktormanagement.domain.valueobjects.Patient;
import mk.finki.emt.docktormanagement.services.DoctorService;
import mk.finki.emt.docktormanagement.services.forms.DoctorForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Doctor findById(DoctorId id) {
        return repository.findById(id).orElseThrow(DoctorNotFoundException::new);
    }

    @Override
    public Doctor addDoctor(DoctorForm form) {
        Doctor d=Doctor.build(form.getDoctorName(), form.getDoctorSurname(), form.getSpecialization(), form.getWorkTime(), form.getExaminationType(), form.getPhoneNumber(), form.getEmailAddress(),form.getRating());
        repository.save(d);
        return d;
    }

    @Override
    public Doctor scheduleAppointmentAdded(DoctorId doctorId, Patient patient) {
       Doctor d=repository.findById(doctorId).orElseThrow(DoctorNotFoundException::new);
       d.addPatientToSchedule(patient.getId());
       return repository.save(d);
    }

    @Override
    public Doctor scheduleAppointmentCanceled(DoctorId doctorId, Patient patient) {
        Doctor d=repository.findById(doctorId).orElseThrow(DoctorNotFoundException::new);
        d.removePatientFromSchedule(patient.getId());
        return repository.save(d);
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }
}
