package portfolio_urless_backend;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import portfolio_urless_backend.customer.infra.CustomerConfig;
import portfolio_urless_backend.url.infra.UrlConfig;

import javax.sql.DataSource;

@Configuration
@Import({CustomerConfig.class, UrlConfig.class})
public class AppConfig {
    @Value("${spring.datasource.driver}")
    private  String driver;

    @Value("${spring.datasource.url}")
    private  String url;

    @Value("${spring.datasource.username}")
    private  String username;

    @Value("${spring.datasource.password}")
    private  String password;

    @Bean
    public  DataSource dbdataSrc() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public  JdbcTemplate dbJdbcTemplate(DataSource dbdataSrc) {
        return new JdbcTemplate(dbdataSrc);
    }


}
