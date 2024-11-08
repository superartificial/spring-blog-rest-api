package nz.clemwhite.blogsite.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Value("${POSTGRES_USER}")
    private String username;

    @Value("${POSTGRES_PASSWORD}")
    private String password;

    @Bean
    public DataSource dataSource() {
        String jdbcUrl = "jdbc:" + databaseUrl.replace("postgres://", "postgresql://");

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
