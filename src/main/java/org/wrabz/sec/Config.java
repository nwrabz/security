package org.wrabz.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.wrabz.sec.controller.CustomEntryPoint;

public class Config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(c ->{
                    c.realmName("OTHER");
                    c.authenticationEntryPoint(new CustomEntryPoint());
                })
                .authorizeHttpRequests(a -> a.anyRequest().authenticated());
        return http.build();

    }
}
