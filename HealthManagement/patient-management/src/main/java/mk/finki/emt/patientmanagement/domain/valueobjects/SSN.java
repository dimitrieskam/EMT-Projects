package mk.finki.emt.patientmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;

import java.io.IOException;
import java.io.OutputStream;

@Embeddable
@Getter
public class SSN implements ValueObject {
    private final int ssn;

    protected SSN(){
        this.ssn=0;
    }



    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}
