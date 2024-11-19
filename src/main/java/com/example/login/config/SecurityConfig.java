package com.example.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import com.example.login.Service.CustomOAuth2UserService;

@Configuration
public class SecurityConfig {
     private final OAuth2UserService<OAuth2UserRequest, OAuth2User> customOAuth2UserService;

     public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }

 @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/oauth2/**").permitAll() // 로그인 페이지 및 OAuth2 요청 허용
                .anyRequest().permitAll() // 기타 요청은 인증 필요
            )
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/success", true) // 로그인 성공 시 리다이렉트 URL
            );

        return http.build();
    }
}
