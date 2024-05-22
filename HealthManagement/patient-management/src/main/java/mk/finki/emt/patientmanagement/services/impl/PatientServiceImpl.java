package mk.finki.emt.patientmanagement.services.impl;

import mk.finki.emt.patientmanagement.domain.exceptions.PatientNotFoundException;
import mk.finki.emt.patientmanagement.domain.models.PatientId;
import mk.finki.emt.patientmanagement.domain.models.Patient;

import mk.finki.emt.patientmanagement.domain.repository.PatientRepository;
import mk.finki.emt.patientmanagement.domain.valueobjects.Doctor;
import mk.finki.emt.patientmanagement.services.PatientService;
import mk.finki.emt.patientmanagement.services.forms.PatientForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findById(PatientId id) {
       return patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);

    }

    @Override
    public Patient addPatient(PatientForm form) {
        Patient p=Patient.build(form.getName(),form.getSurname(),form.getSsn(),form.getNumber(),form.getAddress(),form.getDiseaseHistory());
        patientRepository.save(p);
        return p;
    }

    @Override
    public Patient scheduleAppointmentAdded(PatientId patientId, Doctor doctor) {
        Patient p=patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
        p.addDoctorToSchedule(doctor.getId());

        return patientRepository.save(p);
    }

    @Override
    public Patient scheduleAppointmentCanceled(PatientId patientId, Doctor doctor) {
        Patient p=patientRepository.findById(patientId).orElseThrow(PatientNotFoundException::new);
        p.removeDoctorFromSchedule(doctor.getId());
        return patientRepository.save(p);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
