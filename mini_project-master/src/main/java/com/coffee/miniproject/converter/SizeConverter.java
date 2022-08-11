package com.coffee.miniproject.converter;

import com.coffee.miniproject.model.beverage.Size;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SizeConverter implements AttributeConverter<Size, Long> {

    @Override
    public Long convertToDatabaseColumn(Size size) {
        return size.getCode();
    }

    @Override
    public Size convertToEntityAttribute(Long dbData) {
        return Size.ofCode(dbData);
    }
}
