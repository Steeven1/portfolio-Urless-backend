package portfolio_urless_backend.customer.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import portfolio_urless_backend.customer.app.findAllCustomer.FindAllCustomer;
import portfolio_urless_backend.customer.domain.Customer;
import portfolio_urless_backend.customer.domain.CustomerRepository;

@Configuration
public class CustomerConfig {


    private final JdbcOperations jdbcOperations;

    public CustomerConfig(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Bean
    public CustomerRepository<Customer> customerRepository() {
        return new SqlServerCustomerRepository(jdbcOperations);
    }

    @Bean
    public FindAllCustomer findAllCustomer(CustomerRepository<Customer> customerRepository) {
        return new FindAllCustomer(customerRepository);
    }

    @Bean
    public CustomerController customerController(FindAllCustomer findAllCustomer) {
        return new CustomerController(findAllCustomer);
    }
}
