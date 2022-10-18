package com.coffee.miniproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BoardMain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String contents;

    @Column
    private String img;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    // @JsonBackReference(value = "member-fk")
    private Member member;

    // 자바 객체 사이드에서만 저장됨 (DB에 저장안됨)
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Builder
    public BoardMain(String title, String contents, String img) {
        this.title = title;
        this.contents = contents;
        this.img = img;
    }
}
