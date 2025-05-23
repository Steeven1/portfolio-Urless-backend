package portfolio_urless_backend.customer.domain;


import java.util.List;

public interface CustomerRepository<Entity> {
    public List<Entity> findAll ();
    public void create(Entity customer);
    public Entity findById(Entity customer);
    public void delete(Entity customer);
}
