package com.tsystems.javaschool.brajnikov.internetstore.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.tsystems.javaschool.brajnikov.internetstore.webservice")
public class WebServiceConfiguration implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/resttest").allowedMethods("GET", "PUT", "POST", "GET", "OPTIONS");

    }
}
