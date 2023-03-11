package ru.udisondev.globus.claim.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("Request Method : {}", request.getMethod());
        log.info("Request URI : {}", request.getRequestURI());
        log.info("Request Headers : {}", request.getHeaderNames());
        return true;
    }
}
