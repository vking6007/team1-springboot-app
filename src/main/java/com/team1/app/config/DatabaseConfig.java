package com.team1.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        
        // Add connection properties to handle timezone
        Properties properties = new Properties();
        properties.setProperty("serverTimezone", "UTC");
        properties.setProperty("useTimezone", "true");
        properties.setProperty("useLegacyDatetimeCode", "false");
        
        return builder.build();
    }
}
