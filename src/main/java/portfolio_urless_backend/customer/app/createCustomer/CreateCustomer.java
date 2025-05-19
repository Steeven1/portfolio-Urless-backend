package portfolio_urless_backend.customer.app.createCustomer;

import portfolio_urless_backend.customer.domain.Customer;
import portfolio_urless_backend.customer.domain.CustomerRepository;


public class CreateCustomer {

    private final CustomerRepository<Customer> repo;

    public CreateCustomer(
            CustomerRepository<Customer> repo
    )
    {
        this.repo = repo;
    }

    public void run(String id,
                    String email,
                    String password, String firstname, String lastname) {


        this.repo.create(
                new Customer(
                id = id,
                email = email,
                password = password,
                firstname = firstname,
                lastname = lastname
            )
        );
    }
}
