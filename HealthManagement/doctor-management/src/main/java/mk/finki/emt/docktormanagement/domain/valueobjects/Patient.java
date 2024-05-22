package mk.finki.emt.docktormanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.finki.emt.sharedkernel.domain.contact.EmailAddress;
import mk.finki.emt.sharedkernel.domain.contact.PhoneNumber;

import java.io.IOException;
import java.io.OutputStream;

@Getter
public class Patient implements ValueObject {
    private final PatientId id;
    private final String name;
    private final String surname;
    private final Integer ssn;
    private final EmailAddress address;
    private final PhoneNumber number;


    private Patient() {
        this.id =PatientId.randomId(PatientId.class);
        this.name = "";
        this.surname = "";
        this.ssn = 0;
        this.address = new EmailAddress("");
        this.number = new PhoneNumber("");

    }
    @JsonCreator
    public Patient(@JsonProperty("id") PatientId id,
                   @JsonProperty("patientName") String name,
                   @JsonProperty("patientSurname") String surname,
                   @JsonProperty("patientSSN") Integer ssn,
                   @JsonProperty("EmailAddress") EmailAddress address,
                   @JsonProperty("PhoneNumber") PhoneNumber number
                 ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.address = address;
        this.number = number;
    }

    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}

