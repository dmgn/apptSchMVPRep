package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import app.cal.schedule.api.ClientEnrollmentDetails;
import app.cal.schedule.api.ListMessage;

@Repository
public class JdbcClientEnrollmentReadDao  implements ClientEnrollmentReadDao {

	NamedParameterJdbcTemplate jdbcTemplate;

	public JdbcClientEnrollmentReadDao() {}

	public JdbcClientEnrollmentReadDao(DataSource dataSource){
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public ListMessage<ClientEnrollmentDetails> findAllEnrollmentsFor(
			long clientId) {
		final String sql = "SELECT CEL.CLIENT_ID, CEI.PRODUCT_ID, PI.PRODUCT_NAME, CI.CORPORATE_ID, CEI.VERSION, "
				+ "CEI.INSERT_DT, CEI.ENROLLMENT_ID, CEI.REFERENCE_ID "
				+ "FROM CLIENT_ENROLLMENT_INFO CEI "
				+ "JOIN PRODUCT_INFO PI "
				+ "ON CEI.PRODUCT_ID = PI.PRODUCT_ID "
				+ "JOIN CLIENT_INFO CI "
				+ "ON CEI.CLIENT_ID = CI.CLIENT_ID "
				+ "WHERE CI.CLIENT_ID=:clientId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("clientId", clientId);
		List<ClientEnrollmentDetails> list = jdbcTemplate.query(sql, map, new ClientEnrollmentRowMapper());
		return new ListMessage<ClientEnrollmentDetails>(list);
	}

	@Override
	public ClientEnrollmentDetails findEnrollmentByRefId(String refId) {		
		final String sql = "SELECT * FROM CLIENT_ENROLLMENT_INFO CEI WHERE CEI.REF_ID=:refId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("refId", refId);
		ClientEnrollmentDetails object = jdbcTemplate.queryForObject(sql, map, new CEIDetailsRowMapper());
		return object;
	}

	
	private class CEIDetailsRowMapper implements RowMapper<ClientEnrollmentDetails>{

		@Override
		public ClientEnrollmentDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ClientEnrollmentDetails row = new ClientEnrollmentDetails();
			row.setProductId(rs.getLong("PRODUCT_ID"));
			row.setEnrollId(rs.getLong("ENROLLMENT_ID"));
			row.setClientId(rs.getLong("CLIENT_ID"));
			row.setVersion(rs.getInt("VERSION"));
			row.setEnrolledDate(rs.getDate("INSERT_DT"));
			return row;
		}		
	}
	
	
	
	private class ClientEnrollmentRowMapper implements RowMapper<ClientEnrollmentDetails>{

		@Override
		public ClientEnrollmentDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ClientEnrollmentDetails row = new ClientEnrollmentDetails();
			row.setClientId(rs.getLong("CLIENT_ID"));
			row.setCorpId(rs.getLong("CORPORATE_ID"));
			row.setEnrolledDate(rs.getDate("INSERT_DT"));
			row.setEnrollId(rs.getLong("ENROLLMENT_ID"));
			row.setProductId(rs.getLong("PRODUCT_ID"));
			row.setVersion(rs.getInt("VERSION"));
			row.setReferenceId(rs.getString("REFERENCE_ID"));
			row.setProductName(rs.getString("PRODUCT_NAME"));
			return row;
		}
		
	}

}
