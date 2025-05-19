package portfolio_urless_backend.url.domain.valueobjs;

public class UrlId {
    private Long value;
    private boolean isSuccess;
    private String error;
    public UrlId(Long value){
        this.value = value;
        this.error = "";
        this.isSuccess = true;
        //this.isEmpty(String.valueOf(value));
        //this.isBlank(value);
        //this.isValid(value);

    }

  public Long value(){
    return this.value;
  }

  public String error() {
      return this.error;
  }

  public boolean isSuccess (){
    return this.isSuccess;
  }

    public void isEmpty(){
        if(this.value == null){
            this.error = "UrlId is not defined";
            this.isSuccess = false;
            return;
        }

        this.error = "";
        this.isSuccess = true;
    }

    private void isBlank(String value){
        if(value.isBlank()){
            throw new Error("UrlId is blank");
        }
    }

    private void isValid(String value){
        if(value.isBlank()){
            throw new Error("UrlId is not valid");
        }
    }


}
