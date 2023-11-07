package vn.edu.iuh.fit.www_lab02_week2.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.www_lab02_week2.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if (attribute == null)
            return null;
        return attribute.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getValue() == dbData) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid EmployeeStatus value: " + dbData);
    }

}