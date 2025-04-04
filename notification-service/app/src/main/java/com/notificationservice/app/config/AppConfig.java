package com.notificationservice.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.notificationservice", "com.smsservice"})
@Configuration
public class AppConfig {
}


