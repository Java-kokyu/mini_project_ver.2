/*
package com.coffee.miniproject.service;

import com.coffee.miniproject.dto.CommentDto;
import com.coffee.miniproject.dto.request.ReplyRequestDto;
import com.coffee.miniproject.model.Comment;
import com.coffee.miniproject.model.CommentReply;
import com.coffee.miniproject.repository.CommentReplyRepository;
import com.coffee.miniproject.repository.MemberRepository;
import com.coffee.miniproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {

    private final MemberRepository memberRepository;
    private final CommentReplyRepository commentReplyRepository;
    private final PostRepository postRepository;
    @Transactional
    public void createNewReply(ReplyRequestDto requestDto) throws Throwable {
        CommentReply commentReply = commentReplyRepository.save(
                CommentReply.creatComment(requestDto.getContents(),
                        memberRepository.findById(requestDto.getMemberId()).orElseThrow(Exception::new),
                        postRepository.findById(requestDto.getPostId()).orElseThrow(Exception::new),
                        requestDto.getParentId() != null ?
                                commentReplyRepository.findById(requestDto.getParentId()).orElseThrow(RuntimeException::new) : null)
        );
    }

    public Object findReplyByPostId(Long postid) {

    }
}
*/
