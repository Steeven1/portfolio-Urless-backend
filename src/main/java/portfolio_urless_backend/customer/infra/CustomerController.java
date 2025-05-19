package portfolio_urless_backend.customer.infra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portfolio_urless_backend.customer.app.findAllCustomer.FindAllCustomer;
import portfolio_urless_backend.customer.domain.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private final FindAllCustomer findAllCustomer;


    public CustomerController(
            FindAllCustomer findAllCustomer
    ){

      this.findAllCustomer = findAllCustomer;

    }

    @GetMapping
    public List<Customer> findAll(){

        return findAllCustomer.run();
    }

    
}
