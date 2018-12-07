package com.donggoos.lotto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("/properties/common.properties")
public class EnvironmentConfig {
}
