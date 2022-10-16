/*
package com.coffee.miniproject.controller;

import com.coffee.miniproject.dto.CommentDto;
import com.coffee.miniproject.dto.request.ReplyRequestDto;
import com.coffee.miniproject.model.result.SingleResult;
import com.coffee.miniproject.service.ReplyService;
import com.coffee.miniproject.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    // 응답 관련 요청 Service
    private final ResultService resultService;
    // 댓글 생성
    @PostMapping("/api/post/{postid}/reply")
    public SingleResult<CommentDto> createReply(@RequestBody ReplyRequestDto requestDto) {
        return resultService.handleSingleResult(replyService.createNewReply(requestDto));
    }
    public ResponseEntity<Void> registComment (@PathVariable Long postid, @RequestBody ReplyRequestDto requestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        String username = principal.getUsername();



        return ResponseEntity.ok().build();
    }

    // 댓글 조회
    @GetMapping("/api/post/{postid}/reply")
    public ResponseEntity<List<ReplyResponseDto>> getReplyByPostId (@PathVariable Long postid) {
        return ResponseEntity.ok().body(replyService.findReplyByPostId(postid));
    }
}
*/
