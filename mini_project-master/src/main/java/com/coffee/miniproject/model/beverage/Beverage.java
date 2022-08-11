package com.coffee.miniproject.model.beverage;

import com.coffee.miniproject.converter.SizeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Beverage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Convert(converter = SizeConverter.class)
    private Size size;

    @OneToMany(mappedBy = "beverage")
    @JsonManagedReference(value = "beverage-fk")
    private List<BeverageIngredient> beverageIngredients;
}
