package com.coffee.miniproject.dto;

import com.coffee.miniproject.model.Member;
import com.coffee.miniproject.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@RequiredArgsConstructor
public class SignupDto {
    private String username;
    private String nickname;
    private String password;
    private String passwordCheck;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .userRole(UserRole.USER)
                .nickname(nickname)
                .build();
    }

    public Boolean checkPassword() {
        return this.password.equals(this.passwordCheck);
    }
}
