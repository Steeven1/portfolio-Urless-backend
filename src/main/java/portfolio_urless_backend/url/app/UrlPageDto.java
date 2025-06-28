package portfolio_urless_backend.url.app;
import portfolio_urless_backend.url.domain.entities.Url;
import java.util.List;

public class UrlPageDto {
    private List<Url> urls;
    private boolean hasMore;
    private Long nextCursor;

    public UrlPageDto(List<Url> urls, boolean hasMore, Long nextCursor) {
        this.urls = urls;
        this.hasMore = hasMore;
        this.nextCursor = nextCursor;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public Long getNextCursor() {
        return nextCursor;
    }
}
