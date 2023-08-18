//package com.madcamp.community;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurer {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/security-login/info").authenticated()
//                .antMatchers("/security-login/admin/**").hasAuthority(UserRole.ADMIN.name())
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .usernameParameter("loginId")
//                .passwordParameter("password")
//                .loginPage("/security-login/login")
//                .defaultSuccessUrl("/security-login")
//                .failureUrl("/security-login/login")
//                .and()
//                .logout()
//                .logoutUrl("/security-login/logout")
//                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
//    }
//
//    @Override
//    public void init(SecurityBuilder builder) throws Exception {
//
//    }
//
//    @Override
//    public void configure(SecurityBuilder builder) throws Exception {
//
//    }
//}