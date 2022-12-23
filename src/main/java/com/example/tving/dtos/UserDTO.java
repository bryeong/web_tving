package com.example.tving.dtos;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO extends User {
    private String id;
    private String password;
    private String name;
    private String nickName;
    private String email;
    private String tel;
    private Date registerDate;
    private boolean isSocial;
    private String role;

    public UserDTO(String username,
                   String password,
                   String name,
                   String nickName,
                   String email,
                   String tel,
                   Date registerDate,
                   boolean isSocial,
                   String role,
                   Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = username;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.tel = tel;
        this.registerDate = registerDate;
        this.isSocial = isSocial;
        this.role = role;
    }
}