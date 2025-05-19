package portfolio_urless_backend.url.app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.HashMap;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = UrlDto.Builder.class)

public class UrlDto {
    private final
    Long id;

    private final
    String raw_url;

    private final
    String short_url;

    private final
    HashMap<String, String > errors;

    private final
    String customer_id;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public UrlDto(
    @JsonProperty("id")
    Long id,
    @JsonProperty("raw_url")
    String rawUrl,
    @JsonProperty("short_url")
    String short_url,
    @JsonProperty("errors")
    HashMap<String, String > errors,
    @JsonProperty("customer_id")
    String customerId) {
        this.id = id;
        this.raw_url = rawUrl;
        this.short_url = short_url;
        this.errors = errors;
        this.customer_id = customerId;
    }

    public Long getId() {
        return id;
    }

    public String getRaw_url() {
        return raw_url;
    }

    public String getShort_url() {
    return short_url;
  }

    public HashMap<String, String> getErrors() {
        return this.errors;
    }

    public String getCustomer_id() {
        return customer_id;
    }


  public UrlDto(Builder builder){
        this.id = builder.id;
        this.raw_url = builder.raw_url;
        this.short_url = builder.short_url;
        this.errors = builder.errors;
        this.customer_id = builder.customer_id;
    }
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder{

      private  Long id;
      private  String raw_url;
      private  String short_url;
      private  HashMap<String, String> errors;
      private  String customer_id;

      public UrlDto.Builder id(Long id) {
            this.id = id;
            return this;
      }

      public UrlDto.Builder raw_url(String raw_url) {
            this.raw_url = raw_url;
            return this;
      }

      public UrlDto.Builder short_url(String short_url) {
        this.short_url = short_url;
        return this;
      }

      public UrlDto.Builder errors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
      }

      public UrlDto.Builder customer_id(String customer_id) {
            this.customer_id = customer_id;
            return this;
      }

      public UrlDto build(){
            return new UrlDto(this);
        }
    }


}
