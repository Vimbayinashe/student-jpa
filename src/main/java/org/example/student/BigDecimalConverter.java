package org.example.student;

import javax.persistence.AttributeConverter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalConverter implements AttributeConverter<BigDecimal, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BigDecimal value) {
        if(value == null)
            return null;
        else
            return value.multiply(BigDecimal.valueOf(100)).intValue();
    }

    @Override
    public BigDecimal convertToEntityAttribute(Integer value) {
        if(value == null)
            return null;
        else
            return new BigDecimal(value).divide(BigDecimal.valueOf(100), RoundingMode.HALF_EVEN)
                    .setScale(2, RoundingMode.HALF_EVEN);
    }
}
