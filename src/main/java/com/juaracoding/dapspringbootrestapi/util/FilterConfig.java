package com.juaracoding.dapspringbootrestapi.util;
/*
IntelliJ IDEA 2024.3.2.2 (Community Edition)
Build #IC-243.23654.189, built on January 29, 2025
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 06/02/2025 13:15
@Last Modified 06/02/2025 13:15
Version 1.0
*/

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomHttpFilter> customHttpFilter() {
        FilterRegistrationBean<CustomHttpFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomHttpFilter());
        registrationBean.addUrlPatterns("/*"); // Atur pola url untuk disaring
        registrationBean.setOrder(1); // Atur urutan filter jika ada beberapa

        return registrationBean;
    }
}
