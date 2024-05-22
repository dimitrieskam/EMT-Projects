package mk.finki.emt.patientmanagement.domain.converter;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import mk.finki.emt.patientmanagement.domain.valueobjects.DiseaseHistory;

@Converter(autoApply = true)
public class DiseaseHistoryConverter implements AttributeConverter<DiseaseHistory, String> {

    @Override
    public String convertToDatabaseColumn(DiseaseHistory attribute) {
        return attribute != null ? attribute.getHistoryDetails() : null;
    }

    @Override
    public DiseaseHistory convertToEntityAttribute(String dbData) {
        return dbData != null ? new DiseaseHistory(dbData) : null;
    }
}
