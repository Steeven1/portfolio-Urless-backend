package portfolio_urless_backend.url.app.shortenUrl;

import portfolio_urless_backend.url.app.UrlDto;
import portfolio_urless_backend.url.app.shortenUrl.strategies.ShortenUrlStrategy;
import portfolio_urless_backend.url.domain.entities.Url;
import portfolio_urless_backend.url.domain.UrlRepository;

import java.util.HashMap;
import java.util.Optional;

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
      urlToValid.getRawUrl().isEmpty();
      urlToValid.getId().isEmpty();
      HashMap<String, String> withError = urlToValid.validate();

      if( !withError.isEmpty() ){
        return new UrlDto.Builder()
          .errors( withError )
          .build();
      }

      //Generate short_url
      if( url.getShort_url() == null){
        String short_url = this.shortenUrlStrategy.run(2);
        urlToBuild.short_url( "http://127.0.0.1/urls/" + short_url );
      }

     Url urlToSave = urlToBuild
        .short_url( "http://127.0.0.1/urls/" + url.getShort_url() )
        .build();

      //persist url in database
      this.repo.create(
        urlToSave
      );

      //return UrlDto with only short_url
      return new UrlDto.Builder()
        .short_url(
          urlToSave.getShortUrl().value()
        ).build();



    }


}
