package com.clockin.clockin_backend.security.jwt.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Extract token from Request and give it to SecurityContext of Spring Security to check
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestHeader = request.getHeader(this.tokenHeader);

        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            String authToken = requestHeader.substring(7);
            JwtAuthentication authentication = new JwtAuthentication(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
