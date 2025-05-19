package portfolio_urless_backend.url.domain.valueobjs;

public class CustomerId {
    private String value;
    private String error;
    private boolean isSuccess;

    public CustomerId(String value){
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
    //En el caso de que generar el error no sea un problema
    public void isEmpty(){
        if( this.value.equals("null") ){
          this.error = "CustomerId is not defined";
          this.isSuccess = false;
          return;
        }

        this.error = "";
        this.isSuccess = true;
    }

    //En el caso de que generar el error no sea un problema
    /*
    private void isBlank(String value){
        if(value.isBlank()){
            throw new Error("CustomerId is blank");
        }
    }

     */

  //En el caso de que generar el error no sea un problema

  /*
    private void isValid(String value){
        if(value.isBlank()){
            throw new Error("CustomerId is invalid");
        }
    }

   */
}
