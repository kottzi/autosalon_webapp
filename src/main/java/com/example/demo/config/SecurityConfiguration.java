package com.example.demo.config;

import com.example.demo.models.enums.UserRole;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.security.AppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class SecurityConfiguration {
    private final UserRepository userRepository;
    public SecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
        http
                .authorizeHttpRequests(
                        authorizeHttpRequests ->
                                authorizeHttpRequests.
                                        requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                        .permitAll().
                                        requestMatchers("/", "/login", "/register", "/login-error",
                                                "/brands/all", "/models/all", "/offers/all",
                                                "/brands/search","/models/search","/offers/search",
                                                "/img/homeLogo.jpg").permitAll()
                                        .requestMatchers("/profile").authenticated().
                                        requestMatchers("/brands/add","/brands/deleteAll","/brands/update/**","/brands/delete/**",
                                                "/models/add","/models/deleteAll","/models/update/**", "/models/delete/**",
                                                "/offers/add","/offers/deleteAll","/offers/update/**", "/offers/delete/**",
                                                "/users/all", "/users/deleteAll", "/users/update/**", "/users/delete/**").
                                        hasAuthority(UserRole.ADMIN.getName()).
                                        anyRequest().authenticated()
                )
                .formLogin(
                        (formLogin) ->
                                formLogin
                                        .loginPage("/login")
                                        .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                        .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                                        .defaultSuccessUrl("/")
                                        .failureForwardUrl("/login-error")
                )
                .logout((logout) ->
                        logout.logoutUrl("/logout").
                                logoutSuccessUrl("/").
                                invalidateHttpSession(true)
                ).securityContext(
                        securityContext -> securityContext.
                                securityContextRepository(securityContextRepository)
                );
        return http.build();
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new AppUserDetailsService(userRepository);
    }
}
