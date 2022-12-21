package com.example.tving.handler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Custom403Handler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info(" ------------ Custom403Handler : 403 : ACCESS DENIED -------------------");

    }
}
