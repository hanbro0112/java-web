package com.web.controller;

import com.web.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {

    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_name", "linpingzhi"));
        return Result.success();
    }

    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                log.info("Cookie name: {}, Cookie value: {}", cookie.getName(), cookie.getValue());
            }
        }
        return Result.success();
    }

    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        log.info("HttpSession-s1 : {}", session.hashCode());

        session.setAttribute("loginUser", "tom");
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession-s2 : {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser");
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }
}
