package mk.finki.emt.patientmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.finki.emt.sharedkernel.domain.base.ValueObject;

import java.io.IOException;
import java.io.OutputStream;

public class DiseaseHistory implements ValueObject{
    private String historyDetails;

    // Constructors, getters, setters, etc.
    public DiseaseHistory() {}

    public DiseaseHistory(String historyDetails) {
        this.historyDetails = historyDetails;
    }

    public String getHistoryDetails() {
        return historyDetails;
    }

    public void setHistoryDetails(String historyDetails) {
        this.historyDetails = historyDetails;
    }

    @Override
    public String toString() {
        return historyDetails;
    }


    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {

    }
}
