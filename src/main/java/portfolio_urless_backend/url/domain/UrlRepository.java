package portfolio_urless_backend.url.domain;

import portfolio_urless_backend.url.domain.entities.Url;

import java.util.List;

public interface UrlRepository<Entity> {
    public List<Entity> findAll ();
    public void create(Entity url);
    public List<Entity> findBy(Entity url);
    public void delete(Entity url);
}
