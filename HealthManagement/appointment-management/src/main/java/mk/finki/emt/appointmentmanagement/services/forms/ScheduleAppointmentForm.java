package mk.finki.emt.appointmentmanagement.services.forms;

import lombok.Data;
import lombok.Getter;
import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.docktormanagement.domain.model.DoctorId;
import mk.finki.emt.patientmanagement.domain.models.Patient;
import mk.finki.emt.patientmanagement.domain.models.PatientId;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Getter
public class ScheduleAppointmentForm {
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private PatientId patientId;
    private DoctorId doctorId;

}
