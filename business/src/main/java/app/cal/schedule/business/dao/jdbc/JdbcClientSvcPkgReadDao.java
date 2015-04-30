package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import app.cal.schedule.api.ClientSvcPkgInfoDetails;

public class JdbcClientSvcPkgReadDao implements ClientSvcPkgReadDao {

	NamedParameterJdbcTemplate jdbcTemplate;

	public JdbcClientSvcPkgReadDao(){		
	}
	
	public JdbcClientSvcPkgReadDao(DataSource dataSource){
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public ClientSvcPkgInfoDetails findPkgDtlsForProductByClientId(long corpId,
			long prodId, long clientId) {

		final String sql = "SELECT CPPI.* FROM CLIENT_PRODUCT_PKG_INFO CPPI "
				+ "JOIN CLIENT_ENROLLMENT_INFO CEI "
				+ "ON CEI.ENROLLMENT_ID = CPPI.ENROLLMENT_ID AND CEI.PRODUCT_ID = CPPI.PRODUCT_ID "
				+ "WHERE CEI.CLIENT_ID = :clientId "
				+ "AND CPPI.PRODUCT_ID = :prodId "
				+ "AND CPPI.PKG_END_DT >= sysdate()";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("clientId", clientId);
		map.addValue("prodId", prodId);
		ClientSvcPkgInfoDetails result = jdbcTemplate.queryForObject(sql, map, new ClientSvcPkgRowMapper());
		return result;
	}
	
	private class ClientSvcPkgRowMapper implements RowMapper<ClientSvcPkgInfoDetails>{
		@Override
		public ClientSvcPkgInfoDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			ClientSvcPkgInfoDetails row = new ClientSvcPkgInfoDetails();
			row.setPkgStartDate(rs.getDate("PKG_START_DT"));
			row.setPkgEndDate(rs.getDate("PKG_END_DT"));
			row.setEnrollId(rs.getLong("ENROLLMENT_ID"));
			row.setProductId(rs.getLong("PRODUCT_ID"));
			return row;
		}		
	}

}
