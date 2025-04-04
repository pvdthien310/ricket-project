package com.orderservice.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.orderservice", "com.shipmentserivce", "com.notificationservice", "com.smsservice"})
@Configuration
public class AppConfig {
}
