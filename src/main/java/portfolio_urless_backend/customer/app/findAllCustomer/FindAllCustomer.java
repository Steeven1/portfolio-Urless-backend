package portfolio_urless_backend.customer.app.findAllCustomer;

import portfolio_urless_backend.customer.domain.Customer;
import portfolio_urless_backend.customer.domain.CustomerRepository;

import java.util.List;

public class FindAllCustomer {
    private final CustomerRepository<Customer> repo;


    public FindAllCustomer(
            CustomerRepository<Customer> repo
    )
    {
        this.repo = repo;
    }

    public List<Customer> run() {

        return this.repo.findAll();

    }
}
