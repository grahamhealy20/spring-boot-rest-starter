package app.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by GrahamH on 20/08/2016.
 */
@Configuration
public class DataConfig {

    @Bean
    @Primary
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
