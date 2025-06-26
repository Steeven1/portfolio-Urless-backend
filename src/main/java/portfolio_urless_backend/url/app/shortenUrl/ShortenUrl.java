package portfolio_urless_backend.url.app.shortenUrl;

import portfolio_urless_backend.url.app.UrlDto;
import portfolio_urless_backend.url.app.shortenUrl.strategies.ShortenUrlStrategy;
import portfolio_urless_backend.url.domain.entities.Url;
import portfolio_urless_backend.url.domain.UrlRepository;

import java.util.HashMap;

public class ShortenUrl {

    private final UrlRepository<Url> repo;
    private final ShortenUrlStrategy shortenUrlStrategy;

    public ShortenUrl(UrlRepository<Url> repo,
                      ShortenUrlStrategy shortenUrlStrategy
                      ) {
        this.repo = repo;
        this.shortenUrlStrategy = shortenUrlStrategy;
    }

    public UrlDto run(UrlDto url)  {

      Url.Builder urlToBuild = new Url.Builder()
        .raw_url( url.getRaw_url() )
        .customer_id( url.getCustomer_id() );

      //verify that raw_url not in error
      Url urlToValid = urlToBuild.build();
      HashMap<String, String> problemDetails = urlToValid.validate();
      
      //Generate short_url
       String short_url = url.getShort_url();
       if( short_url == null ){
          short_url = this.shortenUrlStrategy.run(repo.getIntex());
        }

      urlToBuild
        .short_url( "http://127.0.0.1/urls/" + short_url );

      //persist url in database
      this.repo.create(
              urlToBuild.build()
      );

      //return UrlDto with only short_url
      return new UrlDto.Builder()
        .short_url(
          urlToBuild.build().getShortUrlValue()
        )
        .errors( problemDetails )
        .build();



    }


}
