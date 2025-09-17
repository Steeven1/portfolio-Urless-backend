package portfolio_urless_backend.url.app.findByUrl;

import portfolio_urless_backend.url.app.UrlPageDto;
import portfolio_urless_backend.url.domain.UrlRepository;
import portfolio_urless_backend.url.domain.entities.Url;

import java.util.List;

public class FindByUrl {
  private final UrlRepository<Url, UrlPageDto> repo;


  public FindByUrl(
    UrlRepository<Url, UrlPageDto> repo
  )
  {
    this.repo = repo;
  }

  public List<Url> run(Url url) {

    return this.repo.findBy(url);

  }
}
