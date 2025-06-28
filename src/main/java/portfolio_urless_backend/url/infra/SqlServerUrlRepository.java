package portfolio_urless_backend.url.infra;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import portfolio_urless_backend.url.domain.entities.Url;
import portfolio_urless_backend.url.domain.UrlRepository;

import java.util.List;

@Repository
public class SqlServerUrlRepository implements UrlRepository<Url> {

  private final JdbcTemplate jdbcTemplate;

  public SqlServerUrlRepository(
      JdbcTemplate jdbcTemplate
      
      ) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Url> findAll(
      Long cursor,
      Long limit
  ) {

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
        .withProcedureName("getPaginetedUrls")
        .declareParameters(
            new org.springframework.jdbc.core.SqlParameter("cursor", java.sql.Types.BIGINT),
            new org.springframework.jdbc.core.SqlParameter("limit", java.sql.Types.BIGINT)
        )
        .returningResultSet("urls", (rs, rowNum ) -> new Url.Builder()
            .id(rs.getLong("id"))
            .raw_url(rs.getString("raw_url"))
            .short_url(rs.getString("short_url"))
            .customer_id(rs.getString("customer_id"))
            .build());

        var params = new java.util.HashMap<String, Object>();
        params.put("cursor", cursor);
        params.put("limit", limit);

        var result = simpleJdbcCall.execute(params);
      
        if( result.get("urls") != null ) {
          @SuppressWarnings("unchecked")
          List<Url> urls = (List<Url>) result.get("urls");
          return urls;
        }
        
        return List.of();
  }

  @Override
  @Transactional
  public void create(Url url) {

    // noinspection DataFlowIssue
    this.jdbcTemplate
        .update("""
              INSERT INTO urls (raw_url, short_url, customer_id)
              VALUES (?,?,?)
            """, url.getRawUrl().value(), url.getShortUrl().value(), url.getCustomerId().value());

  }

  @Override
  public List<Url> findBy(Url url) {

    String query = """
        select * from urls
        where short_url = ?
        """;

    return this.jdbcTemplate.query(
        query,
        (rs, rowNum) -> new Url.Builder()
            .id(rs.getLong("id"))
            .raw_url(rs.getString("raw_url"))
            .short_url(rs.getString("short_url"))
            .customer_id(rs.getString("customer_id"))
            .build(),
        url.getShortUrl().value());

  }

  @Override
  public void delete(Url url) {

  }

  @Override
  public Long getIntex() {
    // TODO Auto-generated method stub
    String sql = "SELECT CAST(NEXT VALUE  AS BIGINT) FOR url_index";
  return jdbcTemplate.queryForObject(sql, Long.class);
  }

}
