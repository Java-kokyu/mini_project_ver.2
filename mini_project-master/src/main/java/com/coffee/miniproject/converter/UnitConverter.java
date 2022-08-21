package com.coffee.miniproject.converter;

import com.coffee.miniproject.model.beverage.Unit;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UnitConverter implements AttributeConverter<Unit, Long> {
    @Override
    public Long convertToDatabaseColumn(Unit unit) {
        return unit.getCode();
    }

    @Override
    public Unit convertToEntityAttribute(Long dbData) {
        return Unit.ofCode(dbData);
    }
}
