package portfolio_urless_backend.url.domain.valueobjs;

public class UrlShort {
    private String value;
    private String error;
    private boolean isSuccess;

  public UrlShort(String value){
        this.value = String.valueOf(value);
        this.error = "";
        this.isSuccess = true;
        //this.isEmpty(value);
        //this.isBlank(value);
        //this.isValid(value);

  }

  public String value(){
    return this.value;
  }

  public String error(){

    return this.error;
  }

  public boolean isSuccess (){
    return this.isSuccess;
  }

    public void isEmpty(){
        if( this.value == null ){
          this.error = "UrlShort is empty";
          this.isSuccess = false;
          return;
        }
        this.error = "";
        this.isSuccess = true;
    }

    private void isBlank(String value){
        if(value.isBlank()){
            throw new Error("UrlShort is blank");
        }
    }

    private void isValid(String value){
        if(value.isBlank()){
            throw new Error("UrlShort is invalid");
        }
    }
}
