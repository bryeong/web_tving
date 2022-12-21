package com.example.tving.vos;

import lombok.*;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String nickName;
    private String email;
    private String tel;
    private Date registerDate;
    private boolean isSocial;
    private String role;
}
