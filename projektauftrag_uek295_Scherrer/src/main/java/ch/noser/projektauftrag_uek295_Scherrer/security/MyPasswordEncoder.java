package ch.noser.projektauftrag_uek295_Scherrer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyPasswordEncoder {
    @Bean
        // NoOpPasswordEncoder is deprecated, but is at the moment fine
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}