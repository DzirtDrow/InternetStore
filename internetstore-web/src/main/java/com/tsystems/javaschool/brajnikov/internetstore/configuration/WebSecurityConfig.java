package com.tsystems.javaschool.brajnikov.internetstore.configuration;

import com.tsystems.javaschool.brajnikov.internetstore.service.implementations.CustomAuthentificationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
//@EnableWebMvc
@ComponentScan({"com.tsystems.javaschool.brajnikov.internetstore.controller",
        "com.tsystems.javaschool.brajnikov.internetstore.configuration"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    PersistentTokenRepository tokenRepository;

    @Autowired
    private CustomAuthentificationSuccessHandler customAuthentificationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.css");
        web.ignoring().antMatchers("/*.js");
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("nimda").roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/index", "signup").permitAll()
                //.access("hasRole('USER') or hasRole('ADMIN') or hasRole('MANAGER')")
                .antMatchers("/goodslist").access("hasRole('ROLE_admin')or hasRole('ROLE_manager')")
                .antMatchers("/manageorders").access("hasRole('ROLE_admin')or hasRole('ROLE_manager')")
                .antMatchers("/manageoneorder").access("hasRole('ROLE_admin')or hasRole('ROLE_manager')")
                .antMatchers("/admin").access("hasRole('ROLE_admin')or hasRole('ROLE_manager')")
                .antMatchers("/list").access("hasRole('ROLE_admin')")
                .antMatchers("/store").permitAll()
                .antMatchers("/cart").permitAll()
                .antMatchers("/order").authenticated()
                .antMatchers("/account").authenticated()
                .antMatchers("/orders-list").authenticated()
                .and().formLogin().loginPage("/login")
                //.successHandler(customAuthentificationSuccessHandler)
                //.loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                //
                .and().rememberMe().rememberMeParameter("remember-me")
                .tokenRepository(tokenRepository).tokenValiditySeconds(86400)
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/accessdenied");
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        //.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices tokenBasedservice = new PersistentTokenBasedRememberMeServices(
                "remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }
    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver() {
        return new AuthenticationTrustResolverImpl();
    }

}

//
//.antMatchers("/goodslist").access("hasRole('ROLE_admin')or hasRole('ROLE_manager')")
//        .antMatchers("/manageorders").access("hasRole('ROLE_admin')or hasRole('ROLE_manager')")
//        .antMatchers("/list").access("hasRole('ROLE_admin')")
//        .antMatchers("/store").permitAll()
//        .antMatchers("/cart").permitAll()
//        .antMatchers("/order").authenticated()
//        .antMatchers("/account").authenticated()
//        .antMatchers("/orders-list").authenticated()
//        .and().formLogin().loginPage("/login").defaultSuccessUrl( "/index" )
//        //.loginProcessingUrl("/login")
//        .successHandler(customAuthentificationSuccessHandler)
//        .usernameParameter("username").passwordParameter("password")
//        .and().rememberMe().rememberMeParameter("remember-me")
//        .tokenRepository(tokenRepository).tokenValiditySeconds(86400)
//        .and().csrf()
//        .and().exceptionHandling().accessDeniedPage("/accessdenied");