package mk.finki.emt.docktormanagement.services.forms;

import lombok.Data;
import lombok.Getter;
import mk.finki.emt.docktormanagement.domain.valueobjects.ExaminationType;
import mk.finki.emt.docktormanagement.domain.valueobjects.Specialization;
import mk.finki.emt.docktormanagement.domain.valueobjects.WorkTime;
import mk.finki.emt.sharedkernel.domain.contact.EmailAddress;
import mk.finki.emt.sharedkernel.domain.contact.PhoneNumber;

@Data
@Getter
public class DoctorForm {
    private String doctorName;
    private String doctorSurname;
    private Specialization specialization;
    private WorkTime workTime;
    private ExaminationType examinationType;
    private PhoneNumber phoneNumber;
    private EmailAddress emailAddress;
    private Double rating;

}
