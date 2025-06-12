package portfolio_urless_backend.customer.domain;


public class Customer {

    private final CustomerId        id;
    private final CustomerEmail     email;
    private final CustomerPassword  password;
    private final CustomerFirstname firstname;
    private final CustomerLastname  lastname;

    public Customer(
            String id,
            String email,
            String password,
            String firstname,
            String lastname
    ){
        this.id        = new CustomerId(id);
        this.email     = new CustomerEmail(email);
        this.password  = new CustomerPassword(password);
        this.firstname = new CustomerFirstname(firstname);
        this.lastname  = new CustomerLastname(lastname);
    }

    public String getId() {
        return id.value;
    }
    public String getFirstname(){
        return firstname.value;
    }
    public String getLastname(){
        return lastname.value;
    }
    public String getPassword(){
        return this.password.value;
    }
    public String getEmail(){
        return this.email.value;
    }

}