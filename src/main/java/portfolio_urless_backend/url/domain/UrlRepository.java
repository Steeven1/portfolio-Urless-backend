package portfolio_urless_backend.url.domain;

import java.util.List;

public interface UrlRepository<Entity> {
    public List<Entity> findAll (Long cursor);
    public void create(Entity url);
    public List<Entity> findBy(Entity url);
    public void delete(Entity url);
    public Long getIntex();
}
