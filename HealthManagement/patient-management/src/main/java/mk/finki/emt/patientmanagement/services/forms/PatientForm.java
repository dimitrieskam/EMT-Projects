package mk.finki.emt.patientmanagement.services.forms;

import lombok.Data;
import lombok.Getter;
import mk.finki.emt.docktormanagement.domain.valueobjects.PatientId;
import mk.finki.emt.patientmanagement.domain.valueobjects.DiseaseHistory;
import mk.finki.emt.patientmanagement.domain.valueobjects.SSN;
import mk.finki.emt.sharedkernel.domain.contact.EmailAddress;
import mk.finki.emt.sharedkernel.domain.contact.PhoneNumber;

@Data
@Getter
public class PatientForm {
    private final PatientId id;
    private final String name;
    private final String surname;
    private final SSN ssn;
    private final EmailAddress address;
    private final PhoneNumber number;
    private final DiseaseHistory diseaseHistory;
}
