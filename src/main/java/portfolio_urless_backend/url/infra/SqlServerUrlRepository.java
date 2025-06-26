package portfolio_urless_backend.url.infra;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import portfolio_urless_backend.url.domain.entities.Url;
import portfolio_urless_backend.url.domain.UrlRepository;

import java.util.List;

@Repository
public class SqlServerUrlRepository implements UrlRepository<Url> {

  private final JdbcTemplate jdbcTemplate;

  public SqlServerUrlRepository(
      JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Url> findAll(
      Long cursor
  ) {
    String selectAllQuery = """
        SELECT TOP 10 * raw_url, short_url  FROM urls
        WHERE id > cursor
        ORDER BY id DESC
        """;
    // return this.jdbcTemplate.query(
    //     selectAllQuery,
    //     new BeanPropertyRowMapper<>(Url.class));

    return this.jdbcTemplate.query(
        selectAllQuery,
        (rs, rowNum) -> new Url.Builder()
            .id(rs.getLong("id"))
            .raw_url(rs.getString("raw_url"))
            .short_url(rs.getString("short_url"))
            .customer_id(rs.getString("customer_id"))
            .build());
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
