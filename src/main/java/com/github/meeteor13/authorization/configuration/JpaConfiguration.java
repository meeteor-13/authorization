package com.github.meeteor13.authorization.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = {
    "com.github.meeteor13.authorization.domain.entity"
})
@EnableJpaRepositories(value = "com.github.meeteor13.authorization.domain.repository")
public class JpaConfiguration {
}
