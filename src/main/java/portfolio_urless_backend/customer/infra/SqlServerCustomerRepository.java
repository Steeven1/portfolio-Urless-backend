package portfolio_urless_backend.customer.infra;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import portfolio_urless_backend.customer.domain.Customer;
import portfolio_urless_backend.customer.domain.CustomerRepository;

import java.util.List;

@Repository
public class SqlServerCustomerRepository implements CustomerRepository<Customer> {

    private final JdbcOperations jdbcTemplate;


    public SqlServerCustomerRepository(
            JdbcOperations jdbcTemplate
    ){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll(){

        String selectAllQuery = "select * from customers";
        return this.jdbcTemplate.query(
                selectAllQuery,
                new BeanPropertyRowMapper<>(Customer.class));
    }

    public void create(Customer customer) {

    }

    public Customer findById(Customer customer) {
        return null;
    }

    public void delete(Customer customer) {

    }
}
