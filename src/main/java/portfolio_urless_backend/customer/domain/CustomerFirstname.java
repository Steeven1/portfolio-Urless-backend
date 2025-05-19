package portfolio_urless_backend.customer.domain;

public class CustomerFirstname {
    public String value;

    public CustomerFirstname(String value){
        this.value = value;
        this.isEmpty(value);
        this.isBlank(value);

    }

    private void isEmpty(String value){
        if(value.isEmpty()){
            throw new Error("Firstname is undefined");
        }
    }

    private void isBlank(String value){
        if(value.isBlank()){
            throw new Error("Firstname is blank");
        }
    }
}
