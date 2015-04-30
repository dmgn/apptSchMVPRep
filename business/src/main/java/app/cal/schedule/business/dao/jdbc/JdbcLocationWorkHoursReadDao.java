package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.LocationWrkHrsDtls;

public class JdbcLocationWorkHoursReadDao implements LocationWorkHoursReadDao {

	
	NamedParameterJdbcTemplate jdbcTemplate;

	public JdbcLocationWorkHoursReadDao() {}
	
	public JdbcLocationWorkHoursReadDao( DataSource dataSource ) {
		
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	
	@Override
	public ListMessage<LocationWrkHrsDtls> findLocationWorkHours(long corpId, long locId) {
		final String sql = "SELECT * FROM LOCATION_WORK_HRS LWH "
				+ "JOIN CORPORATE_LOCATION_INFO CLI "
				+ "ON LWH.LOCATION_ID = CLI.LOCATION_ID "
				+ " WHERE CLI.CORPORATE_ID=:corpId "
				+ " AND CLI.LOCATION_ID=:locId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		map.addValue("locId", locId);
		List<LocationWrkHrsDtls> locWrkHrsDtlsList = jdbcTemplate.query(sql, map, new LocationWrkHrsDtlsRowMapper());
		return new ListMessage<>(locWrkHrsDtlsList);
	}

	@Override
	public ListMessage<LocationWrkHrsDtls> findWorkHoursForAllLocations(long corpId) {
		final String sql = "SELECT LWH.*, CLI.CORPORATE_ID FROM LOCATION_WORK_HRS LWH "
				+ "JOIN CORPORATE_LOCATION_INFO CLI "
				+ "ON LWH.LOCATION_ID = CLI.LOCATION_ID "
				+ " WHERE CLI.CORPORATE_ID=:corpId ";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		List<LocationWrkHrsDtls> locWrkHrsDtlsList = jdbcTemplate.query(sql, map, new LocationWrkHrsDtlsRowMapper());
		return new ListMessage<>(locWrkHrsDtlsList);	
	}

	private class LocationWrkHrsDtlsRowMapper implements RowMapper<LocationWrkHrsDtls>{

		@Override
		public LocationWrkHrsDtls mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			LocationWrkHrsDtls row = new LocationWrkHrsDtls();
			row.setCorpId(rs.getLong("CORPORATE_ID"));
			row.setStartTime(rs.getString("START_TIME"));
			row.setEndTime(rs.getString("END_TIME"));
			row.setLocationId(rs.getLong("LOCATION_ID"));
			row.setVersion(rs.getInt("VERSION"));
			row.setReferenceId(rs.getString("REF_ID"));
			row.setTimeSlotId(rs.getLong("TIME_SLOT_ID"));
			return row;
		}
		
	}

	@Override
	public ListMessage<CorpLocDetails> findAllLocations(long corpId) {
		final String sql = " SELECT * FROM CORPORATE_LOCATION_INFO CLI WHERE CLI.CORPORATE_ID = :corpId ";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		List<CorpLocDetails> locWrkHrsDtlsList = jdbcTemplate.query(sql, map, new CorpLocDetailsRowMapper());
		return new ListMessage<>(locWrkHrsDtlsList);	
	}
	
	
	private class CorpLocDetailsRowMapper implements RowMapper<CorpLocDetails>{

		@Override
		public CorpLocDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CorpLocDetails row = new CorpLocDetails();
			row.setCorpId(rs.getLong("CORPORATE_ID"));
			row.setLocationId(rs.getLong("LOCATION_ID"));
			row.setVersion(rs.getInt("VERSION"));
			row.setReferenceId(rs.getString("REF_ID"));
			row.setCity(rs.getString("CITY"));
			row.setCountry(rs.getString("COUNTRY"));
			row.setState(rs.getString("STATE"));
			row.setStreet(rs.getString("STREET"));
			row.setTimezone(rs.getString("TIME_ZONE"));
			row.setZipCode(rs.getString("ZIP_CODE"));
			return row;
		}
		
	}
	
	
}
