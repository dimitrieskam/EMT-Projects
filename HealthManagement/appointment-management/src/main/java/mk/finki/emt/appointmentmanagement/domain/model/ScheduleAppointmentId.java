package mk.finki.emt.appointmentmanagement.domain.model;

import jakarta.persistence.Embeddable;
import mk.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

@Embeddable
public class ScheduleAppointmentId extends DomainObjectId {
    public ScheduleAppointmentId() {
        super(ScheduleAppointmentId .randomId(ScheduleAppointmentId .class).getId());
    }

    public ScheduleAppointmentId (@NonNull String uuid) {
        super(uuid);
    }


}