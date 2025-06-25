package portfolio_urless_backend.url.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio_urless_backend.url.app.UrlDto;
import portfolio_urless_backend.url.app.findAllUrl.FindAllUrl;
import portfolio_urless_backend.url.app.findByUrl.FindByUrl;
import portfolio_urless_backend.url.app.shortenUrl.ShortenUrl;
import portfolio_urless_backend.url.domain.entities.Url;

import java.util.List;

@RestController
@RequestMapping("/urls")
public class UrlController {

  private final FindAllUrl findAllUrlUseCase;
  private final ShortenUrl shortenUrlUseCase;
  private final FindByUrl  findByUrlUseCase;
  public UrlController(
    FindAllUrl findAllUrlUseCase,
    ShortenUrl shortenUrlUseCase,
    FindByUrl  findByUrlUseCase
  )
  {
    this.findAllUrlUseCase = findAllUrlUseCase;
    this.shortenUrlUseCase = shortenUrlUseCase;
    this.findByUrlUseCase  = findByUrlUseCase;
  }

  @GetMapping
  public List<Url> findAll(){
    return this.findAllUrlUseCase.run();
  }

  @GetMapping("/{short_url}")
  public ResponseEntity<?> find(
    @PathVariable("short_url") String short_url
  )
  {

    return ResponseEntity.status(HttpStatus.FOUND)
      .header("Location",
        findByUrlUseCase.run(
          new Url.Builder()
            .short_url(short_url)
            .build()
        ).getFirst().getShortUrl().value()

      )
      .build();
  }

  @PostMapping
  public ResponseEntity<?> shortenUrl(
    @RequestBody(required = false)
    final UrlDto url_req
  ){
    if( url_req == null ){
      return ResponseEntity
              .status( HttpStatus.BAD_REQUEST ).build();
    }
    
    UrlDto url =  this.shortenUrlUseCase.run(
          url_req
    );

    if( !url.getErrors().isEmpty() ){
      return ResponseEntity
        .status(
          HttpStatus.BAD_REQUEST
        )
        .body(
          url
        );
    }

    return ResponseEntity
            .status( HttpStatus.CREATED )
            .body(
              url
            );
  }
}
