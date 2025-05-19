package portfolio_urless_backend.customer.domain;

public class CustomerEmail {
    public String value;

    public CustomerEmail(String value){
        this.value = value;
        this.isEmpty(value);
        this.isBlank(value);

    }

    private void isEmpty(String value){
        if(value.isEmpty()){
            throw new Error("Email is undefined");
        }
    }

    private void isBlank(String value){
        if(value.isBlank()){
            throw new Error("Email is blank");
        }
    }
}
