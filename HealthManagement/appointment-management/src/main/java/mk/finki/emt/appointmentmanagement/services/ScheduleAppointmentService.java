package mk.finki.emt.appointmentmanagement.services;


import mk.finki.emt.appointmentmanagement.domain.exceptions.ScheduleAppointmentIdNotExistException;
import mk.finki.emt.appointmentmanagement.domain.exceptions.ScheduleAppointmentNotExistException;
import mk.finki.emt.appointmentmanagement.domain.model.ScheduleAppointment;
import mk.finki.emt.appointmentmanagement.domain.model.ScheduleAppointmentId;
import mk.finki.emt.appointmentmanagement.services.forms.ScheduleAppointmentForm;
import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.patientmanagement.domain.models.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleAppointmentService {
    ScheduleAppointment scheduleAppointment(Patient patient, Doctor doctor, LocalDate date, LocalTime time);
    List<ScheduleAppointment> findAll();
    Optional<ScheduleAppointment> findById(ScheduleAppointmentId id);
    void addAppointment(ScheduleAppointmentId scheduleAppointmentId, ScheduleAppointmentForm scheduleAppointmentForm) throws ScheduleAppointmentIdNotExistException;
    void cancelAppointment(ScheduleAppointmentId scheduleAppointmentId, ScheduleAppointmentForm scheduleAppointmentForm) throws ScheduleAppointmentIdNotExistException, ScheduleAppointmentNotExistException;

}
