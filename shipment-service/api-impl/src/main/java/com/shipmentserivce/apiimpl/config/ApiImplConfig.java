package com.shipmentserivce.apiimpl.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.shipmentserivce")
@EntityScan(basePackages = "com.shipmentserivce.apiimpl.services.persistence.model")
public class ApiImplConfig {
}
