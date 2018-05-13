package com.tsystems.javaschool.brajnikov.internetstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
//@ComponentScan("com.tsystems.javaschool.brajnikov.internetstore")
@ComponentScan({"com.tsystems.javaschool.brajnikov.internetstore.controller",
                "com.tsystems.javaschool.brajnikov.internetstore.configuration"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("/views/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/list").setViewName("list");
        registry.addViewController("/goodslist").setViewName("goodslist");
        registry.addViewController("/addgoods").setViewName("addgoods");
        registry.addViewController("/editgoods").setViewName("editgoods");
        registry.addViewController("/signup").setViewName("signup");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

}