package com.tsystems.javaschool.brajnikov.internetstore.configuration;

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
        http.authorizeRequests().antMatchers("/", "/index").permitAll()
                //.access("hasRole('USER') or hasRole('ADMIN') or hasRole('MANAGER')")
                .antMatchers("/goodslist").access("hasRole('ROLE_admin')or hasRole('MANAGER')")
                .antMatchers("/list").access("hasRole('ROLE_admin')")
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .and().rememberMe().rememberMeParameter("remember-me")
                .tokenRepository(tokenRepository).tokenValiditySeconds(86400)
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/accessdenied");

//        http.authorizeRequests()
//                .antMatchers("/login**").permitAll()
//                .antMatchers("/list").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/goodslist").permitAll()
//                .and().formLogin().loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().exceptionHandling().accessDeniedPage("/accessdenied");
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
    //.defaultSuccessUrl("/", false);
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/index").permitAll()
//                .anyRequest().authenticated();
//        http
//                .formLogin()
//                .loginPage("/login")
//                //.usernameParameter("username")//
//                //.passwordParameter("password")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        http
//                .authorizeRequests()
//                .antMatchers("/list").access("hasRole('ROLE_ADMIN')");
//
//        http
//                .authorizeRequests()
//                .antMatchers("/editgoods").access("hasAnyRole('MANAGER','ADMIN')");

//        http.authorizeRequests().and()
//                .rememberMe().tokenRepository(this.persistentTokenRepository())
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

//    }


//    @Bean
//    WebMvcConfigurer myWebMvcConfigurer() {
//        return new WebMvcConfigurer() {
//
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/list").setViewName("list");
//                registry.addViewController("/goodslist").setViewName("goodslist");
//                registry.addViewController("/addgoods").setViewName("addgoods");
//                registry.addViewController("/editgoods").setViewName("editgoods");
//                registry.addViewController("/signup").setViewName("signup");
//                registry.addViewController("/login").setViewName("login");
//            }
//        };
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        return viewResolver;
//    }


}
