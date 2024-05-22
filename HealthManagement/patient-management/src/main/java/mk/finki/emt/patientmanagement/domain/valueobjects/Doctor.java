package mk.finki.emt.patientmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.finki.emt.docktormanagement.domain.valueobjects.PatientId;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.finki.emt.sharedkernel.domain.contact.EmailAddress;
import mk.finki.emt.sharedkernel.domain.contact.PhoneNumber;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;

@Getter
public class Doctor implements ValueObject {
    private final DoctorId id;
    private final String name;
    private final String surname;
    private final String specialization;
    private final LocalTime workTime;
    private final String examinationType;
    private final EmailAddress address;
    private final PhoneNumber number;
    private final Double rating;


    private Doctor() {
        this.id =DoctorId.randomId(DoctorId.class);
        this.name = "";
        this.surname = "";
        this.specialization="";
        this.workTime=null;
        this.examinationType="";
        this.address = new EmailAddress("");
        this.number = new PhoneNumber("");
        this.rating=0.0;
    }
    @JsonCreator
    public Doctor(@JsonProperty("id") DoctorId id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("specialization") String specialization,
                  @JsonProperty("workTime") LocalTime workTime,
                  @JsonProperty("examinationType") String examinationType,
                  @JsonProperty("address") EmailAddress address,
                  @JsonProperty("number") PhoneNumber number,
                  @JsonProperty("rating") Double rating) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.workTime = workTime;
        this.examinationType = examinationType;
        this.address = address;
        this.number = number;
        this.rating = rating;
    }

    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {
    }
}
