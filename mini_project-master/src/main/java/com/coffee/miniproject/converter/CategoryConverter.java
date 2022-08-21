package com.coffee.miniproject.converter;

import com.coffee.miniproject.model.beverage.Category;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CategoryConverter implements AttributeConverter<Category, Long> {
    @Override
    public Long convertToDatabaseColumn(Category category) {
        return category.getCode();
    }

    @Override
    public Category convertToEntityAttribute(Long dbData) {
        return Category.ofCode(dbData);
    }
}
