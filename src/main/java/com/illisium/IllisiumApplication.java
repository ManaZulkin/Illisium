package com.illisium;

import com.illisium.bin.IMPL.Armor;
import com.illisium.bin.base.Stats;
import com.illisium.bin.en.ArmorType;
import com.illisium.bin.en.Rare;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                .requestMatchers("/gm/**").hasRole("ADMIN")
                .requestMatchers("/auth/**", "/common/**").permitAll()
                .anyRequest().hasAnyRole("USER", "ADMIN")
        )
                .formLogin(form -> form.loginPage("/auth/login")
                        .loginProcessingUrl("/process_login")
                        .defaultSuccessUrl("/startPage")
                        .failureUrl("/auth/login?error")
                )
                .logout(logout ->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login")
                );

        return http.build();
    }
}
