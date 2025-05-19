package portfolio_urless_backend.customer.domain;

public class CustomerPassword {
    public String value;

    public CustomerPassword(String value){
        this.value = value;
        this.isEmpty(value);
        this.isBlank(value);

    }

    private void isEmpty(String value){
        if(value.isEmpty()){
            throw new Error("Password is undefined");
        }
    }

    private void isBlank(String value){
        if(value.isBlank()){
            throw new Error("Password is blank");
        }
    }
}
