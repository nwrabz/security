package org.wrabz.sec.config;

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

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        var userDetailsService = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("user1")
                .password("password")
                .roles("ADMIN")
                .build();
        var user2 = User.withUsername("user2")
                .password("password")
                .authorities("read", "premium")
                .build();

        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(
                        new RequestValidationFilter(),
                        BasicAuthenticationFilter.class
                )
                .addFilterAfter(
                        new AuthenticationLoggingFilter(),
                        BasicAuthenticationFilter.class
                )
                .authorizeHttpRequests(auth -> auth
                        .anyRequest()
                        .permitAll()
                );
        return http.build();
    }
}
