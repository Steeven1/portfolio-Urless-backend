package portfolio_urless_backend.url.app.findByUrl;

import portfolio_urless_backend.url.domain.UrlRepository;
import portfolio_urless_backend.url.domain.entities.Url;

import java.util.List;

public class FindByUrl {
  private final UrlRepository<Url> repo;


  public FindByUrl(
    UrlRepository<Url> repo
  )
  {
    this.repo = repo;
  }

  public List<Url> run(Url url) {

    return this.repo.findBy(url);

  }
}
