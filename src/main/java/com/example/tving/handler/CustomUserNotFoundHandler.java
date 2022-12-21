package com.example.tving.handler;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserNotFoundHanlder extends UsernameNotFoundException {
    public CustomUserNotFoundHanlder(String msg) {
        super(msg);
    }

    private void customUserNotFoundHanlder(){

    }
}
