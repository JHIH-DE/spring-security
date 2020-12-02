package com.advantech.springsecurity.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages ={"com.advantech.springsecurity.jpa.entity"})
@EnableJpaRepositories(basePackages = "com.advantech.springsecurity.jpa.repository")
public class DaoConfig {
}