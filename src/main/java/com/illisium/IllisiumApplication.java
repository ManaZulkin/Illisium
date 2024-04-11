package com.illisium;

import com.illisium.config.sequrity.MySimpleUrlAuthenticationSuccessHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@SpringBootApplication

public class IllisiumApplication {

    public static void main(String[] args) {
        SpringApplication.run(IllisiumApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(requests ->requests
                        .requestMatchers("/css/**").permitAll()
                .requestMatchers("/gm/**").hasRole("ADMIN")
                .requestMatchers("/player/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/auth/**", "/messege/**").permitAll()
                .anyRequest().hasAnyRole("USER", "ADMIN")
        )
                .formLogin(form -> form.loginPage("/auth/login")
                        .loginProcessingUrl("/process_login")
                        .successHandler(myAuthenticationSuccessHandler())
                        .failureUrl("/auth/login?error")
                )
                .logout(logout ->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login")
                )
                .sessionManagement(sessionManagement -> sessionManagement
                                .sessionFixation().none()
                                .sessionCreationPolicy(SessionCreationPolicy.NEVER)


                );
        return http.build();
    }



    public AuthenticationSuccessHandler myAuthenticationSuccessHandler (){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

}
