package com.example.TaskManagementService.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest; //Incoming Request
        final HttpServletResponse response = (HttpServletResponse) servletResponse; //Outgoing Response
        final String authHeader = request.getHeader("authorization");
        if("OPTIONS".equals(request.getMethod())){ //Capture the request and matches with the header of the token recived through the incoming request. Only iif it matches with the token it will send a response
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);

        } else {
            if (authHeader==null || !authHeader.startsWith("Bearer")){ //Our token header will start with 'Bearer'. If it does'nt start with bearer it means invalid authorization. header may not be seen by us, but it will be there in the incomming request token
                throw new ServletException("Missing or Invalid Authorization Header");
            }
            final String token = authHeader.substring(7);
            final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
            filterChain.doFilter(request,response);
        }
    }
}

