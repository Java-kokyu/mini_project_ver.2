package com.coffee.miniproject.model;

import com.coffee.miniproject.converter.SizeConverter;
import com.coffee.miniproject.model.beverage.Beverage;
import com.coffee.miniproject.model.beverage.BeverageIngredient;
import com.coffee.miniproject.model.beverage.Size;
import com.coffee.miniproject.util.Timestamped;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Recipe extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

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

    public Recipe(Member member, Beverage beverage, String title, String contents, String img, Long sizeCode) {
        this.member = member;
        this.beverage = beverage;
        this.title = title;
        this.contents = contents;
        this.img = img;
        this.size = Size.ofCode(sizeCode);
    }

    @Getter
    @RequiredArgsConstructor
    public static class Request {
        private String title;
        private String contents;
        private String img;
        private String beverage;
        private Long sizeCode;
        private List<BeverageIngredient.Request> ingredients;


        public Request(String title, String contents, String img, String beverage, Long sizeCode, List<BeverageIngredient.Request> ingredients) {
            this.title = title;
            this.contents = contents;
            this.img = img;
            this.beverage = beverage;
            this.sizeCode = sizeCode;
            this.ingredients = ingredients;
        }
    }

    @Getter
    public static class ResponseDetail {
        private final Long id;
        private final String title;
        private final String contents;
        private final String nickname;
        private final String img;
        private final LocalDateTime date;
        private final String beverage;
        private final int sizeVolume;
        private final String size;
        private final List<BeverageIngredient.Response> ingredients;

        public ResponseDetail(Recipe recipe, List<BeverageIngredient.Response> ingredients) {
            this.id = recipe.getId();
            this.title = recipe.getTitle();
            this.contents = recipe.getContents();
            this.nickname = recipe.getMember().getNickname();
            this.img = recipe.getImg();
            this.date = recipe.getCreatedAt();
            this.beverage = recipe.getBeverage().getBeverage();
            this.sizeVolume = recipe.getSize().getSizeVolume();
            this.size = recipe.getSize().getSize();
            this.ingredients = ingredients;
        }

    }

    @Getter
    public static class Response {
        private Long id;
        private String title;
        private String contents;
        private String nickname;
        private String img;
        private LocalDateTime date;
        private int likeCount;
        private Boolean checkLike;

        public Response(Recipe recipe, int likeCount, Boolean checkLike) {
            this.id = recipe.getId();
            this.title = recipe.getTitle();
            this.contents = recipe.getContents();
            this.nickname = recipe.getMember().getNickname();
            this.img = recipe.getImg();
            this.date = recipe.getCreatedAt();
            this.likeCount = likeCount;
            this.checkLike = checkLike;
        }

        public Response(Recipe recipe) {
            this.id = recipe.getId();
            this.title = recipe.getTitle();
            this.contents = recipe.getContents();
            this.nickname = recipe.getMember().getNickname();
            this.img = recipe.getImg();
            this.date = recipe.getCreatedAt();
        }
    }
}
