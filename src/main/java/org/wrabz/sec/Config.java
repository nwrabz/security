package org.wrabz.sec;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class Config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true)
                )

                .authorizeHttpRequests(a -> a.anyRequest().authenticated());
        return http.build();

    }
}
