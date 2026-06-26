package com.kdt.security3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 2단계: URL별 공개/보호 정책과 역할 기반 인가를 명시합니다.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {

        return new InMemoryUserDetailsManager(
                User.withUsername("duke").password(encoder.encode("1111")).roles("USER").build(),
                User.withUsername("admin").password(encoder.encode("adminpass")).roles("ADMIN").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .antMatchers("/resources/**", "/public/**").permitAll()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
//            .formLogin(Customizer.withDefaults());
                        .formLogin(
                        form -> form.successHandler(
                                (request, response, authentication) -> {
                                    boolean admin = authentication.getAuthorities().stream().anyMatch(
                                            authority -> "ROLE_ADMIN".equals(authority.getAuthority())
                                    );

                                    String targetUrl = admin ? "/admin" : "/";

//                                    response.sendRedirect(request.getContextPath() + targetUrl);
                                    response.sendRedirect(targetUrl);
                                }
                        )
                );
        return http.build();
    }
}
