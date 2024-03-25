package com.gdy.springsecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //confinguration 컨테이너로 등록
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/", "/login", "/loginProc","/join","/joinProc").permitAll() //루트 경로에서 작업 진행
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/my/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()//위에서 처리하지 못한 경로들 처리하는 메소드
                );

        http
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/loginProc") //form에서 post로 보내는 action값
                        .permitAll() //해당 경로는 모든 유저가 들어올 수 있다.
                );

        http
                .csrf((auth)->auth.disable());


        return http.build();
    }
}
