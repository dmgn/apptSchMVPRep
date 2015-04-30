package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import scala.annotation.meta.param;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.TutorDetails;
import app.cal.schedule.api.TutorScheduleDetails;
import app.cal.schedule.api.TutorScheduleResponseDtls;

@Repository
public class JdbcTutorReadDao implements TutorReadDao {

	NamedParameterJdbcTemplate jdbcTemplate;
	
	public JdbcTutorReadDao() {}
	
	public JdbcTutorReadDao(DataSource dataSource){
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public ListMessage<TutorDetails> findAllTutorsFor(long corpId) {
		final String sql = "SELECT TI.TUTOR_ID, TI.CORPORATE_ID, TI.TUTOR_NAME, TI.VERSION, TI.UPDATE_DATE, TI.REF_ID, TSM.PRODUCT_ID, PI.PRODUCT_NAME FROM "
				+ "TUTOR_INFO TI LEFT JOIN TUTOR_SERVICE_MAP TSM "
				+ "ON TI.TUTOR_ID = TSM.TUTOR_ID "
				+ "LEFT JOIN PRODUCT_INFO PI "
				+ "ON PI.PRODUCT_ID = TSM.PRODUCT_ID "
				+ "WHERE TI.CORPORATE_ID=:corpId ";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("corpId", corpId);
		List<TutorDetails> tutorDtlsList = jdbcTemplate.query(sql, map, new TutorDetailsRowMapper());
		List<TutorDetails> filteredTutorDtlsList = new LinkedList<>();
		for(TutorDetails obj : tutorDtlsList){
			if( obj == null){
				continue;
			}else{
				filteredTutorDtlsList.add(obj);
			}
		}
		return new ListMessage<>(filteredTutorDtlsList);	
	}


	@Override
	public TutorDetails findTutorByRefId(String refId) {
		final String sql = "SELECT * FROM TUTOR_INFO WHERE REF_ID=:refId";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("refId", refId);
		TutorDetails tutorDtls = jdbcTemplate.queryForObject(sql, map, new TutorDetailsRowMapper());
		return tutorDtls;	
	}
	
	private class TutorDetailsRowMapper implements RowMapper<TutorDetails>{

		TutorDetails tutDtls = null;
		List<Long> productIds = null;
		@Override
		public TutorDetails mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			
			if( tutDtls == null || tutDtls.getTutorId() != rs.getLong("TUTOR_ID")){
				tutDtls = new TutorDetails();
				productIds = new LinkedList<>();
				tutDtls.setCorpId(rs.getLong("CORPORATE_ID"));
				tutDtls.setReferenceId(rs.getString("REF_ID"));
				tutDtls.setLastUpdated(rs.getDate("UPDATE_DATE"));
				tutDtls.setVersion(rs.getInt("VERSION"));
				tutDtls.setTutorId(rs.getLong("TUTOR_ID"));
				tutDtls.setTutorName(rs.getString("TUTOR_NAME"));
				tutDtls.setProductIds(productIds);
				tutDtls.getProductIds().add(rs.getLong("PRODUCT_ID"));
				tutDtls.getProductNames().add(rs.getString("PRODUCT_NAME"));
				return tutDtls;
			}else{
				tutDtls.getProductIds().add(rs.getLong("PRODUCT_ID"));
				tutDtls.getProductNames().add(rs.getString("PRODUCT_NAME"));
				return null;
			}
		}
		
	}

	@Override
	public ListMessage<TutorScheduleResponseDtls> findTutorSchedule(long tutorId,
			long productId, long locationId) {

		String sql = " SELECT TS.TS_ID, TS.SCHEDULE_DATE, PI.PRODUCT_NAME, LWH.LOCATION_ID, LWH.START_TIME, LWH.END_TIME FROM TUTOR_SCHEDULE TS "
				+ "JOIN PRODUCT_INFO PI "
				+ "ON TS.PRODUCT_ID = PI.PRODUCT_ID "
				+ "JOIN LOCATION_WORK_HRS LWH "
				+ "ON TS.TIME_SLOT_ID = LWH.TIME_SLOT_ID "
				+ "WHERE TS.TUTOR_ID = :tutorId AND TS.SCHEDULE_DATE >= SYSDATE() ORDER BY TS.SCHEDULE_DATE";
		
		TutorScheduleParamBuilder paramBuilder = new TutorScheduleParamBuilder(sql);
		paramBuilder.getMap().addValue("tutorId", tutorId);
		if(productId > 0){
			paramBuilder.withProductId(productId);
		}
		if(locationId > 0){
			paramBuilder.withLocationId(locationId);
		}
		List<TutorScheduleResponseDtls> response = jdbcTemplate.query(paramBuilder.getSql().toString(), paramBuilder.getMap(),
				new TutorScheduleResponseDtlsRowMapper());		
		return new ListMessage<TutorScheduleResponseDtls>(response);
	}
	
	private class TutorScheduleResponseDtlsRowMapper implements RowMapper<TutorScheduleResponseDtls>{

		@Override
		public TutorScheduleResponseDtls mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			TutorScheduleResponseDtls row = new TutorScheduleResponseDtls();
			row.setProdName(rs.getString("PRODUCT_NAME"));
			row.setScheduleDate(rs.getDate("SCHEDULE_DATE"));
			row.setStartTime(rs.getString("START_TIME"));
			row.setEndTime(rs.getString("END_TIME"));
			row.setLocationId(rs.getLong("LOCATION_ID"));
			row.setTutorScheduleId(rs.getLong("TS_ID"));
			return row;
		}
		
		
	}


	

}
