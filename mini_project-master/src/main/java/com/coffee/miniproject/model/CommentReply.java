package com.coffee.miniproject.model;

import com.coffee.miniproject.util.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentReply extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @Lob
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Enumerated(value = EnumType.STRING)
    private DeleteStatus isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private CommentReply parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<CommentReply> children = new ArrayList<>();

    public static CommentReply creatComment(String contents, Member member, CommentReply parent){
        CommentReply commentReply = new CommentReply();
        commentReply.contents = contents;
        commentReply.member = member;
        commentReply.parent = parent;
        commentReply.isDeleted = DeleteStatus.N;
        return commentReply;
    }
    public void changeDeletedStatus(DeleteStatus deleteStatus) {
        this.isDeleted = deleteStatus;
    }
}