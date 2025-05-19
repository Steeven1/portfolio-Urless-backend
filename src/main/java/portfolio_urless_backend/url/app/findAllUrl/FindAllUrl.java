package portfolio_urless_backend.url.app.findAllUrl;

import portfolio_urless_backend.url.domain.entities.Url;
import portfolio_urless_backend.url.domain.UrlRepository;

import java.util.List;

public class FindAllUrl {
    private final UrlRepository<Url> repo;


    public FindAllUrl(
            UrlRepository<Url> repo
    )
    {
        this.repo = repo;
    }

    public List<Url> run() {

        return this.repo.findAll();

    }
}
