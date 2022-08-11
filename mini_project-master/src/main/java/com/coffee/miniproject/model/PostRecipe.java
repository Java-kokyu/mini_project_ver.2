package com.coffee.miniproject.model;

import com.coffee.miniproject.converter.SizeConverter;
import com.coffee.miniproject.model.beverage.Beverage;
import com.coffee.miniproject.model.beverage.Ingredient;
import com.coffee.miniproject.model.beverage.Size;
import com.coffee.miniproject.util.Timestamped;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class PostRecipe extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String img;

    @Convert(converter = SizeConverter.class)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @JsonBackReference(value = "member-fk")
    private Member member;

    @OneToOne
    @JoinColumn(name = "BEVERAGE_ID")
    private Beverage beverage;

    @Getter
    @RequiredArgsConstructor
    public static class Request {
        private String title;
        private String contents;
        private String img;
        private String beverage;
        private Long sizeCode;
        private List<Ingredient> ingredients;


        public Request(String title, String contents, String img, String beverage, Long sizeCode, List<Ingredient> ingredients) {
            this.title = title;
            this.contents = contents;
            this.img = img;
            this.beverage = beverage;
            this.sizeCode = sizeCode;
            this.ingredients = ingredients;
        }
    }
}
