package com.fzh.sshop.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CrosFilter {
    @Bean
    CorsFilter getCorsFilter() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);
        cors.addAllowedMethod("*");
        cors.addAllowedOrigin("*");
        cors.setMaxAge(3600L);
        cors.addAllowedHeader("*");
        cors.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);

        CorsFilter corsFilter = new CorsFilter(source);
        return corsFilter;
    }
}