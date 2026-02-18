package org.wrabz.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.wrabz.sec.filter.AuthenticationLoggingFilter;
import org.wrabz.sec.filter.RequestValidationFilter;
import org.wrabz.sec.filter.StaticKeyAuthenticationFilter;

@Configuration
public class ProjectConfig {

    private final StaticKeyAuthenticationFilter filter;

    public ProjectConfig(StaticKeyAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterAt(filter,//Add the filter at the position of Basic Authentication filter
                        BasicAuthenticationFilter.class)
                /*
                .addFilterBefore(
                        new RequestValidationFilter(),
                        BasicAuthenticationFilter.class
                )
                .addFilterAfter(
                        new AuthenticationLoggingFilter(),
                        BasicAuthenticationFilter.class
                ) */
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .permitAll()
                );
        return http.build();
    }
}
