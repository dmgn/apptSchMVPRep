package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import app.cal.schedule.api.ClientGroupDetails;
import app.cal.schedule.api.ClientInfoDetails;
import app.cal.schedule.api.ListMessage;

@Repository
public class JdbcClientInfoReadDao implements ClientInfoReadDao {

	NamedParameterJdbcTemplate jdbcTemplate;

	public JdbcClientInfoReadDao() {}
	
	public JdbcClientInfoReadDao( DataSource dataSource ){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public ListMessage<ClientInfoDetails> findAllClientsFor(long corpId) {
		final String sql = "SELECT * FROM CLIENT_INFO WHERE CORPORATE_ID=:corpId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		List<ClientInfoDetails> list = jdbcTemplate.query(sql, map, new ClientInfoDetailsRowMapper());
		return new ListMessage<ClientInfoDetails>(list);
	}

	@Override
	public ClientInfoDetails findClientByRefId(String refId) {
		final String sql = "SELECT CI.* FROM CLIENT_INFO CI, CLIENT_GROUP CG WHERE CI.GROUP_ID = CG.GROUP_ID AND CG.REF_ID=:refId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("refId", refId);
		ClientInfoDetails object = jdbcTemplate.queryForObject(sql, map, new ClientInfoDetailsRowMapper());
		return object;
	}

	private class ClientInfoDetailsRowMapper implements RowMapper<ClientInfoDetails>{

		@Override
		public ClientInfoDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ClientInfoDetails result = new ClientInfoDetails();
			result.setDob(rs.getDate("DOB"));
			result.setEmailId(rs.getString("EMAIL_ID"));
			result.setFirstName(rs.getString("FIRST_NAME"));
			result.setLastName(rs.getString("LAST_NAME"));
			result.setCorpId(rs.getLong("CORPORATE_ID"));
			result.setReferenceId(rs.getString("REF_ID"));
			result.setVersion(rs.getInt("VERSION"));
			result.setClientId(rs.getLong("CLIENT_ID"));
			return result;
		}		
	}

	@Override
	public ClientInfoDetails findClientByEmailId(String emailId) {
		final String sql = "SELECT CI.*, CG.GROUP_ID FROM CLIENT_INFO CI, CLIENT_GROUP CG WHERE CI.GROUP_ID = CG.GROUP_ID AND CI.EMAIL_ID=:emailId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("emailId", emailId);
		ClientInfoDetails object = jdbcTemplate.queryForObject(sql, map, new ClientInfoAndGrpDetailsRowMapper());
		return object;
	}
	
	
	private class ClientInfoAndGrpDetailsRowMapper implements RowMapper<ClientInfoDetails>{

		@Override
		public ClientInfoDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ClientInfoDetails result = new ClientInfoDetails();
			result.setDob(rs.getDate("DOB"));
			result.setEmailId(rs.getString("EMAIL_ID"));
			result.setFirstName(rs.getString("FIRST_NAME"));
			result.setLastName(rs.getString("LAST_NAME"));
			result.setCorpId(rs.getLong("CORPORATE_ID"));
			result.setReferenceId(rs.getString("REF_ID"));
			result.setVersion(rs.getInt("VERSION"));
			result.setClientId(rs.getLong("CLIENT_ID"));
			ClientGroupDetails cg = new ClientGroupDetails();
			cg.setGroupId(rs.getString("GROUP_ID"));			
			result.setGroup(cg);
			return result;
		}		
	}
	
}
