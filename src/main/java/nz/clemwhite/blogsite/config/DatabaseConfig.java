package nz.clemwhite.blogsite.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Bean
    public DataSource dataSource() {
        String jdbcUrl = "jdbc:" + databaseUrl.replace("postgres://", "postgresql://");
        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username("${POSTGRES_USER}")
                .password("${POSTGRES_PASSWORD}")
                .build();
    }
}
