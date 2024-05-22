package mk.finki.emt.appointmentmanagement.services.impl;

import mk.finki.emt.appointmentmanagement.domain.exceptions.ScheduleAppointmentIdNotExistException;
import mk.finki.emt.appointmentmanagement.domain.exceptions.ScheduleAppointmentNotExistException;
import mk.finki.emt.appointmentmanagement.domain.model.ScheduleAppointment;
import mk.finki.emt.appointmentmanagement.domain.model.ScheduleAppointmentId;
import mk.finki.emt.appointmentmanagement.domain.repository.ScheduleAppointmentRepository;
import mk.finki.emt.appointmentmanagement.services.ScheduleAppointmentService;
import mk.finki.emt.appointmentmanagement.services.forms.ScheduleAppointmentForm;
import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.docktormanagement.domain.repository.DoctorRepository;
import mk.finki.emt.patientmanagement.domain.models.Patient;
import mk.finki.emt.patientmanagement.domain.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class ScheduleAppointmentServiceImpl implements ScheduleAppointmentService {
    private final ScheduleAppointmentRepository repository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public ScheduleAppointmentServiceImpl(ScheduleAppointmentRepository repository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }
    @Override
    public ScheduleAppointment scheduleAppointment(Patient patient, Doctor doctor, LocalDate date, LocalTime time) {
        ScheduleAppointmentId id = new ScheduleAppointmentId();
        ScheduleAppointment appointment = new ScheduleAppointment(id,patient, doctor, date, time);
        return repository.save(appointment);
    }

    @Override
    public List<ScheduleAppointment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ScheduleAppointment> findById(ScheduleAppointmentId id) {
        return repository.findById(id);
    }

    @Override
    public void addAppointment(ScheduleAppointmentId scheduleAppointmentId, ScheduleAppointmentForm scheduleAppointmentForm) throws ScheduleAppointmentIdNotExistException {
        ScheduleAppointment scheduleAppointment = repository.findById(scheduleAppointmentId).orElseThrow(ScheduleAppointmentIdNotExistException::new);
        Patient patient = patientRepository.findById(scheduleAppointmentForm.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        Doctor doctor = doctorRepository.findById(scheduleAppointmentForm.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid doctor ID"));

        ScheduleAppointment newAppointment = new ScheduleAppointment(new ScheduleAppointmentId(), patient, doctor, scheduleAppointmentForm.getAppointmentDate(), scheduleAppointmentForm.getAppointmentTime());
        repository.save(newAppointment);
    }

    @Override
    public void cancelAppointment(ScheduleAppointmentId scheduleAppointmentId, ScheduleAppointmentForm scheduleAppointmentForm) throws ScheduleAppointmentIdNotExistException, ScheduleAppointmentNotExistException {
        ScheduleAppointment scheduleAppointment = repository.findById(scheduleAppointmentId).orElseThrow(ScheduleAppointmentIdNotExistException::new);
        repository.delete(scheduleAppointment);
    }
}
