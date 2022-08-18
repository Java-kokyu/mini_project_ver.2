package com.coffee.miniproject.service;

import com.coffee.miniproject.model.Member;
import com.coffee.miniproject.repository.MemberRepository;
import com.coffee.miniproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {
    private final MemberRepository memberRepository;

    public static String getUsername() {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    public Long getUserId(){
        String username = getUsername();
        Member member =  memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저입니다.")
        );
        return member.getId();
    }

    public Member getUser(){
        String username = getUsername();
        return memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저입니다.")
        );
    }
}
