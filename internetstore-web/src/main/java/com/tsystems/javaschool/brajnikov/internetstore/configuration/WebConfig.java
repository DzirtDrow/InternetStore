package com.tsystems.javaschool.brajnikov.internetstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * The Web config.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.tsystems.javaschool.brajnikov.internetstore.controller",
                "com.tsystems.javaschool.brajnikov.internetstore.configuration",
                "com.tsystems.javaschool.brajnikov.internetstore.webservices"})
public class WebConfig implements WebMvcConfigurer {


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("/views/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/list").setViewName("list");
        registry.addViewController("/goodslist").setViewName("goodslist");
        registry.addViewController("/addgoods").setViewName("addgoods");
        registry.addViewController("/editgoods").setViewName("editgoods");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/accessdenied").setViewName("accessdenied");
        registry.addViewController("/store").setViewName("store");
        registry.addViewController("/cart").setViewName("cart");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/orders-list").setViewName("orders-list");
        registry.addViewController("/manageorders").setViewName("manageorders");
        registry.addViewController("/manageoneorder").setViewName("manageoneorder");
        registry.addViewController("/account").setViewName("account");
        registry.addViewController("/orderPay").setViewName("orderPay");
        //registry.addViewController("/error").setViewName("error");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/details").setViewName("details");
        registry.addViewController("/edituserbyadmin").setViewName("edituserbyadmin");
        registry.addViewController("/test").setViewName("test");


    }

    /**
     * Sets view resolver.
     *
     * @return the view resolver
     */
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

}