package portfolio_urless_backend.url.app.shortenurl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;

import portfolio_urless_backend.url.app.UrlDto;
import portfolio_urless_backend.url.app.shortenUrl.ShortenUrl;

class ShortenUrlTest {

    @Test
    void testShortenUrl() {
        String longUrl = "https://www.example.com/some/long/url";
       
    }

    @Test
    void testShortenInvalidUrl() {
        String invalidUrl = "not a valid url";
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ShortenUrl shortenUrl = new ShortenUrl(null, null); // Assuming you have a constructor that takes these parameters
            shortenUrl.run(new UrlDto.Builder().raw_url(invalidUrl).build());
        });
        
        assertEquals("Invalid URL", exception.getMessage());
    }
}