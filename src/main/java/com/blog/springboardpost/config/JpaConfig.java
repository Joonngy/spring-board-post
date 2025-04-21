package com.blog.springboardpost.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@EnableAutoConfiguration
@Configuration
public class JpaConfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("joonghoon");
    }
}
