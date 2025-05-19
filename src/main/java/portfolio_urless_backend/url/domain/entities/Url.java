package portfolio_urless_backend.url.domain.entities;

import portfolio_urless_backend.url.domain.valueobjs.CustomerId;
import portfolio_urless_backend.url.domain.valueobjs.UrlId;
import portfolio_urless_backend.url.domain.valueobjs.UrlRaw;
import portfolio_urless_backend.url.domain.valueobjs.UrlShort;

import java.util.HashMap;

public class Url {
    private final UrlId id;
    private final UrlRaw raw_url;
    private final UrlShort short_url;
    private final CustomerId customer_id;

    public Url(
            Long id,
            String raw_url,
            String short_url,
            String customer_id
    ){
        this.id        = new UrlId(id);
        this.raw_url   = new UrlRaw(raw_url);
        this.short_url = new UrlShort(short_url);
        this.customer_id = new CustomerId(customer_id);
    }

    public UrlId getId() {
        return this.id;
    }
    public UrlRaw getRawUrl(){
        return this.raw_url;
    }
    public UrlShort getShortUrl(){
        return this.short_url;
    }
    public CustomerId getCustomerId(){
        return this.customer_id;
    }

  public HashMap<String, String> validate() {
    HashMap<String, String> errors = new HashMap<>();

    if (!raw_url.isSuccess()) {
      errors.put("raw_url", raw_url.error());
    }

    if (!customer_id.isSuccess()) {
      errors.put("customer_id", customer_id.error());
    }

    if (!id.isSuccess()) {
      errors.put("id", id.error());
    }

    if (!short_url.isSuccess()) {
      errors.put("id", customer_id.error());
    }

    return errors;
  }

  public Url(Url.Builder builder){
    this.id = new UrlId(builder.id);
    this.raw_url = new UrlRaw(builder.raw_url);
    this.short_url = new UrlShort(builder.short_url);
    this.customer_id = new CustomerId(builder.customer_id);
  }

  public static class Builder{
    private  Long id;
    private  String raw_url;
    private  String short_url;
    private  String customer_id;

    public Url.Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Url.Builder raw_url(String raw_url) {
      this.raw_url = raw_url;
      return this;
    }

    public Url.Builder short_url(String short_url) {
      this.short_url = short_url;
      return this;
    }

    public Url.Builder customer_id(String customer_id) {
      this.customer_id = customer_id;
      return this;
    }



    public Url build(){
      return new Url(this);
    }
  }


}
