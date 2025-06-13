package portfolio_urless_backend.url.app.shortenUrl.strategies;

public class Base62ShortenUrlStrategy implements ShortenUrlStrategy{

    private final String elements;

    public Base62ShortenUrlStrategy(){
       this.elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    @Override
    public String run(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt( (n % 62) ) );
            n /= 62;
        }
        while (sb.length() != 7) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}
