package com.springsecurity.sandbox.configuration.auth;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter {

    private static Logger log = Logger.getLogger(AuthFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        SecurityContextHolder.clearContext();
        String username = request.getHeader("username");
        String password = request.getHeader("password");

        try {
            UserDetails user = userDetailsService.loadUserByUsername(username);
            if(password.equals(user.getPassword())) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, "");
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                throw new AccessDeniedException("Access for User "+username+" denied. Invalid Password");
            }
        } catch (UsernameNotFoundException ex) {
            log.error(ex);
        }


        filterChain.doFilter(request, response);
    }
}
