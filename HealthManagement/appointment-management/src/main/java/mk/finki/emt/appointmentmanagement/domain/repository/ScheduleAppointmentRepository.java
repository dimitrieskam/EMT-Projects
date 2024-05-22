package mk.finki.emt.appointmentmanagement.domain.repository;

import mk.finki.emt.appointmentmanagement.domain.model.ScheduleAppointment;
import mk.finki.emt.appointmentmanagement.domain.model.ScheduleAppointmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleAppointmentRepository extends JpaRepository<ScheduleAppointment, ScheduleAppointmentId> {
}
