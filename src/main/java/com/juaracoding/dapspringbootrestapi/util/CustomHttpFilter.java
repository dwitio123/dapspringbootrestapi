package com.juaracoding.dapspringbootrestapi.util;
/*
IntelliJ IDEA 2024.3.2.2 (Community Edition)
Build #IC-243.23654.189, built on January 29, 2025
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 06/02/2025 13:10
@Last Modified 06/02/2025 13:10
Version 1.0
*/

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomHttpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        //Logika sebelum memproses request
        System.out.println("Request URI: " + httpRequest.getRequestURI());
        System.out.println("Request Method: " + httpRequest.getMethod());

        // Lanjut ke filter chain
        filterChain.doFilter(servletRequest, servletResponse);

        // Logika setelah proses request
        System.out.println("Response sent");
    }
}
