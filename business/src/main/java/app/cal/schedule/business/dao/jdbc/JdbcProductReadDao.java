package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.ProductDetails;

@Repository
public class JdbcProductReadDao implements ProductReadDao {

	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public ProductDetails findProductByRefId(String refId) {
		final String sql = "SELECT * FROM PRODUCT_INFO WHERE REF_ID=:refId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("refId", refId);
		ProductDetails prodDetails = jdbcTemplate.queryForObject(sql, map, new ProductDetailsRowMapper());
		return prodDetails;
	}

	@Override
	public ListMessage<ProductDetails> findAllProductsFor( long corpId ) {
		final String sql = "SELECT * FROM PRODUCT_INFO WHERE CORPORATE_ID=:corpId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		List<ProductDetails> prodDtlsList = jdbcTemplate.query(sql, map, new ProductDetailsRowMapper());
		return new ListMessage<>(prodDtlsList);	
	}

	public JdbcProductReadDao( DataSource datasource ){
		jdbcTemplate = new NamedParameterJdbcTemplate(datasource);		
	}

	public JdbcProductReadDao(){}
	
	private class ProductDetailsRowMapper implements RowMapper<ProductDetails>{

		@Override
		public ProductDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ProductDetails pd = new ProductDetails();
			pd.setLastUpdated(rs.getDate("UPDATE_DATE"));
			pd.setProductName(rs.getString("PRODUCT_NAME"));
			pd.setReferenceId(rs.getString("REF_ID"));
			pd.setUnitPrice(rs.getDouble("UNIT_PRICE"));
			pd.setProductId(rs.getLong("PRODUCT_ID"));
			pd.setVersion(rs.getInt("VERSION"));
			pd.setCapacity(rs.getLong("ROOM_CAPACITY"));
			return pd;
		}		
		
	}

	@Override
	public ListMessage<ProductDetails> findAllProductsByTutorId(long tutorId) {
		final String sql = "SELECT PI.* FROM TUTOR_SERVICE_MAP TSM "
				+ "JOIN PRODUCT_INFO PI "
				+ "ON PI.PRODUCT_ID = TSM.PRODUCT_ID "
				+ "WHERE TSM.TUTOR_ID=:tutorId ";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("tutorId", tutorId);
		List<ProductDetails> prodDtlsList = jdbcTemplate.query(sql, map, new ProductDetailsRowMapper());
		return new ListMessage<>(prodDtlsList);	
	}

	@Override
	public ListMessage<ProductDetails> findProductsByClientId(long clientId) {
		final String sql = "SELECT PI.* FROM CLIENT_PRODUCT_PKG_INFO CPPI "
				+ "JOIN CLIENT_ENROLLMENT_INFO CEI "
				+ "ON CEI.ENROLLMENT_ID = CPPI.ENROLLMENT_ID AND CEI.PRODUCT_ID = CPPI.PRODUCT_ID "
				+ "JOIN PRODUCT_INFO PI "
				+ "ON CEI.PRODUCT_ID = PI.PRODUCT_ID "
				+ "WHERE CEI.CLIENT_ID = :clientId "
				+ "AND CPPI.PKG_END_DT >= sysdate()";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("clientId", clientId);
		List<ProductDetails> prodDtlsList = jdbcTemplate.query(sql, map, new ProductDetailsRowMapper());
		return new ListMessage<>(prodDtlsList);	
	}
	
}
