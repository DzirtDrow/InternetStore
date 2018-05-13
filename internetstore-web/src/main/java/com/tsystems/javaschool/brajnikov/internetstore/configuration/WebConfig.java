package com.tsystems.javaschool.brajnikov.internetstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
////@EnableWebSecurity
////@ComponentScan("com.tsystems.javaschool.brajnikov.internetstore")
@ComponentScan({"com.tsystems.javaschool.brajnikov.internetstore.controller",
                "com.tsystems.javaschool.brajnikov.internetstore.configuration"})
public class WebConfig implements WebMvcConfigurer{ //extends WebMvcConfigurerAdapter {

    //@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/views/**").addResourceLocations("/views/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
//
    //@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/list").setViewName("list");
        registry.addViewController("/goodslist").setViewName("goodslist");
        registry.addViewController("/addgoods").setViewName("addgoods");
        registry.addViewController("/editgoods").setViewName("editgoods");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        return manager;
//    }

//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/resources/**", "/signup", "/about").permitAll()
//                .antMatchers("/admin/**", "/list").hasRole("admin")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }

}