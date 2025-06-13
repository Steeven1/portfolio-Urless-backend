class ShortenUrlTest {

    @Test
    void testShortenUrl() {
        String longUrl = "https://www.example.com/some/long/url";
        String shortUrl = ShortenUrl.shorten(longUrl);
        
        assertNotNull(shortUrl);
        assertTrue(shortUrl.startsWith("http://short.url/"));
        assertNotEquals(longUrl, shortUrl);
    }

    @Test
    void testShortenInvalidUrl() {
        String invalidUrl = "not a valid url";
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ShortenUrl.shorten(invalidUrl);
        });
        
        assertEquals("Invalid URL", exception.getMessage());
    }
}