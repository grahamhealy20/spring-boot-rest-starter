package app.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.net.URI;

/**
 * Created by grahamhealy on 18/08/2016.
 */

/**
 * Used to configure any data access bean
 */
@Configuration
public class DataConfig {

    /*
    * JDBC DataStore setup
    */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws Exception {

        String username = "Enter username here";
        String password = "Enter password here";
        String dbUrl = "Enter DB URI here";

        return DataSourceBuilder
                .create()
                .url(dbUrl)
                .username(username)
                .password(password)
                .driverClassName("org.postgresql.Driver")
                .build();
    }

}
