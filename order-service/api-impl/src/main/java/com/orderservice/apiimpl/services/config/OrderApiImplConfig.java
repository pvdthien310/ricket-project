package com.orderservice.apiimpl.services.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.orderservice")
@EntityScan(basePackages = "com.orderservice.apiimpl.services.persistence.model")
public class OrderApiImplConfig {
}
