package portfolio_urless_backend.url.domain.valueobjs;

public class UrlRaw {
  private String value;
  private String error;
  private boolean isSuccess;

  public UrlRaw(String value) {
    this.value = String.valueOf(value);
    this.error = "";
    this.isSuccess = true;

  }

  public String value() {
    return this.value;
  }

  public boolean isSuccess() {
    return this.isSuccess;
  }

  public String error() {
    return this.error;
  }

  public void isEmpty() {
    if (this.value.equals("null")) {
      this.error = "UrlRaw is no defined";
      this.isSuccess = false;
      return;
    }
    this.error = "";
    this.isSuccess = true;
  }

  private void isBlank(String value) {
    if (value.isBlank()) {
      throw new Error("UrlRaw is blank");
    }
  }

}
