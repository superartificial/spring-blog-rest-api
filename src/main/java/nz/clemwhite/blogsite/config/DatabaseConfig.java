package nz.clemwhite.blogsite.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${DATABASE_URL:}")
    private String databaseUrl;

    @Bean
    public DataSource dataSource() {
        if (databaseUrl != null && !databaseUrl.isEmpty()) {
            // Convert Railway's DATABASE_URL to JDBC format
            String jdbcUrl = databaseUrl.replace("postgres://", "jdbc:postgresql://");

            return DataSourceBuilder.create()
                    .url(jdbcUrl)
                    .build();
        }

        // Fallback for local development
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/blogdb")
                .username("postgres")
                .password("postgres")
                .build();
    }
}
