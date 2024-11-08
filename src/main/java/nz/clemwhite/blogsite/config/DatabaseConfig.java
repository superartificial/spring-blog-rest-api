package nz.clemwhite.blogsite.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

//@Configuration
public class DatabaseConfig {

    @Value("${PGHOST:localhost}")
    private String host;

    @Value("${PGPORT:5432}")
    private String port;

    @Value("${PGDATABASE:blogdb}")
    private String database;

    @Value("${PGUSER:postgres}")
    private String username;

    @Value("${PGPASSWORD:postgres}")
    private String password;

    @Bean
    public DataSource dataSource() {
        System.out.println("CONGIG");
        String jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s", host, port, database);

        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .build();
    }
}
