package portfolio_urless_backend.url.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import portfolio_urless_backend.url.app.findAllUrl.FindAllUrl;
import portfolio_urless_backend.url.app.findByUrl.FindByUrl;
import portfolio_urless_backend.url.app.shortenUrl.ShortenUrl;
import portfolio_urless_backend.url.app.UrlPageDto;
import portfolio_urless_backend.url.app.shortenUrl.strategies.Base62ShortenUrlStrategy;
import portfolio_urless_backend.url.app.shortenUrl.strategies.ShortenUrlStrategy;
import portfolio_urless_backend.url.domain.entities.Url;
import portfolio_urless_backend.url.domain.UrlRepository;

@Configuration
public class UrlConfig {
  private final JdbcTemplate jdbcTemplate;

  @Bean
  public ShortenUrlStrategy base64ShortenUrlStrategy() {
    return new Base62ShortenUrlStrategy();
  }

  public UrlConfig(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Bean
  public UrlRepository<Url, UrlPageDto> urlRepository() {
    return new SqlServerUrlRepository(jdbcTemplate);
  }

  @Bean
  public FindByUrl findByUrl(UrlRepository<Url, UrlPageDto> urlRepository) {
    return new FindByUrl(urlRepository);
  }

  @Bean
  public FindAllUrl findAllUrl(UrlRepository<Url, UrlPageDto> urlRepository) {
      return new FindAllUrl(urlRepository);
  }

  @Bean
  public ShortenUrl shortenUrl(
    UrlRepository<Url, UrlPageDto> urlRepository,
    Base62ShortenUrlStrategy base64ShortenUrlStrategy
  ) 
  {
    return new ShortenUrl(
                urlRepository,
                base64ShortenUrlStrategy
    );
  }

  @Bean
  public UrlController urlController(
      FindAllUrl findAllUrl,
      ShortenUrl shortenUrl,
      FindByUrl findByUrl
    ) 
    {
    // Create and return the UrlController with the required dependencies
    // This is where you can inject the FindAllUrl, ShortenUrl, and FindByUrl services
    // into the UrlController constructor.
    // Assuming UrlController has a constructor that takes these services as parameters
    // Adjust the constructor parameters as needed based on your actual UrlController implementation.
      return new UrlController(findAllUrl, shortenUrl, findByUrl);
    }
}
