package com.donggoos.lotto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "/properties/common.properties", ignoreResourceNotFound = true)
public class EnvironmentConfig {
}
