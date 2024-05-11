package com.over.seaes.consultancy.OverseasConsultancyPogramme.configraion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(this.userDetailsService);
        authenticationProvider.setPasswordEncoder(this.passwordEncoder);

        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/consultant/**").hasRole("CONSULTANT")
                        .requestMatchers("/student/**").hasRole("STUDENT")
                        .requestMatchers("/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()).formLogin(form -> {
                    form.loginPage("/signin").loginProcessingUrl("/doLogin").successHandler((request, response, authentication) -> {
                        for (GrantedAuthority authority : authentication.getAuthorities()) {
                            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                                response.sendRedirect("/admin/index");
                                return;
                            } else if (authority.getAuthority().equals("ROLE_CONSULTANT")) {
                                response.sendRedirect("/consultant/index");
                                return;
                            }
                        }
                        response.sendRedirect("/student/index");
                    }).failureUrl("/signin?error=true");


                });


        return httpSecurity.build();
    }
}
