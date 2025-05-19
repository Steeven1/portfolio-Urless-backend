package portfolio_urless_backend.customer.domain;

import java.util.UUID;

public class CustomerId {
    public String value;

    CustomerId(String value){
        this.value = value;
        isValid(value);
    }

    private void isValid(String value){
        UUID.fromString(value);
    }

}
