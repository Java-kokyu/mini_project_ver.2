package com.coffee.miniproject.dto;

import com.coffee.miniproject.model.Comment;
import com.coffee.miniproject.model.CommentReply;
import com.coffee.miniproject.model.DeleteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String contents;
    private Long userId;
    private String nickname;
    private List<CommentDto> children = new ArrayList<>();

    public CommentDto(Long id, String contents, Long userId, String nickname) {
        this.id = id;
        this.contents = contents;
        this.userId = userId;
        this.nickname = nickname;
    }
    public static CommentDto convertCommentToDto(CommentReply commentReply) {
        return commentReply.getIsDeleted() == DeleteStatus.Y ?
                new CommentDto(commentReply.getId(), "삭제된 댓글입니다.", null, null) :
                new CommentDto(commentReply.getId(), commentReply.getContents(), commentReply.getMember().getId(), commentReply.getMember().getNickname());
    }
}
