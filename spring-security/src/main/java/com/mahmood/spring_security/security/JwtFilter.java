package com.mahmood.spring_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//public class JwtFilter extends OncePerRequestFilter {
//
//    @Autowired
//    JwtService jwtService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Auth");
//
//        String token = null;
//        String username = null;
//        if(authHeader != null && authHeader.startsWith("Bearer ")){
//            token = authHeader.substring(7);
//            username = jwtService.extractUserName(token);
//
//        }
//
//        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){
//            if(jwtService.validateToken(token, username)){
//
//            }
//        }
//        filterChain.doFilter(request,response);
//    }
//}
