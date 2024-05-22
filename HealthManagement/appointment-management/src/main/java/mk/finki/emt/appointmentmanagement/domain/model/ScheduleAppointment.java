package mk.finki.emt.appointmentmanagement.domain.model;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.lang.NonNull;
import mk.finki.emt.docktormanagement.domain.model.Doctor;
import mk.finki.emt.patientmanagement.domain.models.Patient;
import mk.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Getter
public class ScheduleAppointment extends AbstractEntity<ScheduleAppointmentId> {

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_" +
            "id", nullable = false)
    private Doctor doctor;


    public ScheduleAppointment(@NonNull ScheduleAppointmentId id, @NonNull Patient patient, @NonNull Doctor doctor,  @NonNull LocalDate appointmentDate, @NonNull LocalTime appointmentTime) {
        super(id);
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.doctor = doctor;
    }



    public ScheduleAppointment() {
        super(new ScheduleAppointmentId());
    }

}
