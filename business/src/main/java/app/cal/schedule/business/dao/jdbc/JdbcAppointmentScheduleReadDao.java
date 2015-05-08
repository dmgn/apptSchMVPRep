package app.cal.schedule.business.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.business.dao.sp.StoredProcGetTimeSlotDetails;
import app.cal.schedule.common.AppointmentStatus;

public class JdbcAppointmentScheduleReadDao implements
		AppointmentScheduleReadDao {

	StoredProcGetTimeSlotDetails spGetTimeSlotDetails;
	
	NamedParameterJdbcTemplate jdbcTemplate;
	
	public JdbcAppointmentScheduleReadDao(){}
	
	public JdbcAppointmentScheduleReadDao(StoredProcGetTimeSlotDetails spGetTimeSlotDetails, DataSource datasource){
		this.spGetTimeSlotDetails = spGetTimeSlotDetails;
		this.jdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}
	
	@Override
	public List<AppointmentResponseDtls> bookAppointments(long prodId,
			Date startDt, Date endDt, long locId, long timeSlotId, String selectedDays, long clientId, long groupId) {
		Map<String, Object> map = new HashMap<>();
		map.put("P_CLIENT_ID", clientId);
		map.put("P_GROUP_ID", groupId);
		map.put("P_IS_RECURRING", 0);
		map.put("P_PROD_ID", prodId);
		map.put("P_TIME_SLOT_ID", timeSlotId);
		map.put("P_START_DT", startDt);
		map.put("P_END_DT", endDt);
		map.put("P_SELECTED_DAYS", selectedDays);
		Map<String, Object> out = spGetTimeSlotDetails.execute(map);
		@SuppressWarnings("unchecked")
		List<AppointmentResponseDtls> result = (List<AppointmentResponseDtls>) out.get("ResultList");
		return result;
	}

	@Override
	public ListMessage<AppointmentResponseDtls> findScheduleStatus(String emailId,
			long clientId, long groupId) {
		
		final String sql = "SELECT CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME, CSI.STATUS FROM "
				+ " TUTOR_SCHEDULE TS "
				+ " JOIN CLIENT_SCHEDULE_INFO CSI "
				+ "	ON CSI.TS_ID = TS.TS_ID AND CSI.SCHEDULE_DT >= SYSDATE() "
				+ " JOIN LOCATION_WORK_HRS LWH "
				+ "	ON LWH.TIME_SLOT_ID = TS.TIME_SLOT_ID "
				+ " JOIN CLIENT_INFO CI "
				+ " ON CI.CLIENT_ID = CSI.CLIENT_ID "
				+ " WHERE CI.EMAIL_ID = :emailId"
				+ " ORDER BY CSI.SCHEDULE_DT, CSI.TS_ID ";
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("emailId", emailId);
		List<AppointmentResponseDtls> schdDtls = jdbcTemplate.query(sql, map, new ScheduleDtlsRowMapper());
		return new ListMessage<>(schdDtls);	
	}
	
	public class ScheduleDtlsRowMapper implements RowMapper<AppointmentResponseDtls>{

		@Override
		public AppointmentResponseDtls mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			AppointmentResponseDtls row = new AppointmentResponseDtls();
			row.setEndTime(rs.getString("END_TIME"));
			row.setStartTime(rs.getString("START_TIME"));
			row.setStatus( AppointmentStatus.get(rs.getInt("STATUS")).getText() );
			row.setReqDate(rs.getDate("SCHEDULE_DT"));
		
			return row;
		}

	}

	@Override
	public ListMessage<AppointmentResponseDtls> findAllAppointments(int status) {
		final String sql = "SELECT CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME, CSI.TS_ID, count(*) CNT "
				+ "FROM  TUTOR_SCHEDULE TS "
				+ "JOIN CLIENT_SCHEDULE_INFO CSI "
				+ "ON CSI.TS_ID = TS.TS_ID AND CSI.SCHEDULE_DT >= SYSDATE() "
				+ "JOIN LOCATION_WORK_HRS LWH "
				+ "ON LWH.TIME_SLOT_ID = TS.TIME_SLOT_ID "
				+ "JOIN CLIENT_INFO CI "
				+ "ON CI.CLIENT_ID = CSI.CLIENT_ID "
				+ "WHERE CSI.STATUS = :status "
				+ "GROUP BY CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME, CSI.TS_ID "
				+ "ORDER BY  CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME";    
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("status", status);
		List<AppointmentResponseDtls> schdDtls = jdbcTemplate.query(sql, map, new BookedAppointmentsRowMapper());
		return new ListMessage<>(schdDtls);	
	}
	
	public class BookedAppointmentsRowMapper implements RowMapper<AppointmentResponseDtls>{

		@Override
		public AppointmentResponseDtls mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			AppointmentResponseDtls row = new AppointmentResponseDtls();
			row.setEndTime(rs.getString("END_TIME"));
			row.setStartTime(rs.getString("START_TIME"));
			row.setCount(rs.getInt("CNT"));
			row.setReqDate(rs.getDate("SCHEDULE_DT"));		
			row.setTutorSchId(rs.getLong("TS_ID"));
			return row;
		}

	}

	@Override
	public ListMessage<AppointmentResponseDtls> displayAppointmentsInCalView(
			String startDt, String endDt) {
		int status = 1;
		final String sql = "SELECT CSI.SCHEDULE_ID, CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME, CSI.TS_ID, TI.TUTOR_NAME, TS.PRODUCT_ID, CI.CLIENT_ID, CI.FIRST_NAME, CI.LAST_NAME "
				+ "FROM  TUTOR_SCHEDULE TS "
				+ "JOIN CLIENT_SCHEDULE_INFO CSI "
				+ "ON CSI.TS_ID = TS.TS_ID AND CSI.SCHEDULE_DT >= SYSDATE() AND CSI.SCHEDULE_DT BETWEEN CAST(:startDt AS DATE) and CAST(:endDt AS DATE) "
				+ "JOIN LOCATION_WORK_HRS LWH "
				+ "ON LWH.TIME_SLOT_ID = TS.TIME_SLOT_ID "
				+ "JOIN CLIENT_INFO CI "
				+ "ON CI.CLIENT_ID = CSI.CLIENT_ID "
				+ "JOIN TUTOR_INFO TI "
				+ "ON TI.TUTOR_ID = TS.TUTOR_ID "
				+ "WHERE CSI.STATUS = :status "
				+ "ORDER BY  CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME";    
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("status", status);
		map.addValue("startDt", startDt);
		map.addValue("endDt", endDt);
		List<AppointmentResponseDtls> schdDtls = jdbcTemplate.query(sql, map, new CalendarViewMapper());
		return new ListMessage<>(schdDtls);	
	}
	
	
	
	public class CalendarViewMapper implements RowMapper<AppointmentResponseDtls>{

		@Override
		public AppointmentResponseDtls mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			AppointmentResponseDtls row = new AppointmentResponseDtls();
			row.setEndTime(rs.getString("END_TIME"));
			row.setStartTime(rs.getString("START_TIME"));
			row.setReqDate(rs.getDate("SCHEDULE_DT"));	
			row.setClientId(rs.getLong("CLIENT_ID"));
			row.setfName(rs.getString("FIRST_NAME"));
			row.setlName(rs.getString("LAST_NAME"));
			row.setProdId(rs.getLong("PRODUCT_ID"));
			row.setTutorSchId(rs.getLong("SCHEDULE_ID"));
			row.setTutorName(rs.getString("TUTOR_NAME"));
			return row;
		}

	}

	@Override
	public ListMessage<AppointmentResponseDtls> viewCandidatesForTimeSlot(
			long tutorSchdId) {
		int status = 1;
		final String sql = "SELECT TI.TUTOR_NAME, PI.PRODUCT_NAME, CI.FIRST_NAME, CI.LAST_NAME "
				+ "FROM  TUTOR_SCHEDULE TS "
				+ "JOIN CLIENT_SCHEDULE_INFO CSI "
				+ "ON CSI.TS_ID = TS.TS_ID AND CSI.SCHEDULE_DT >= SYSDATE() "
				+ "JOIN LOCATION_WORK_HRS LWH "
				+ "ON LWH.TIME_SLOT_ID = TS.TIME_SLOT_ID "
				+ "JOIN CLIENT_INFO CI "
				+ "ON CI.CLIENT_ID = CSI.CLIENT_ID "
				+ "JOIN TUTOR_INFO TI "
				+ "ON TI.TUTOR_ID = TS.TUTOR_ID "
				+ "JOIN PRODUCT_INFO PI "
				+ "ON PI.PRODUCT_ID = TS.PRODUCT_ID "
				+ "WHERE CSI.STATUS = :status and CSI.TS_ID = :tutorSchdId "
				+ "ORDER BY  CSI.SCHEDULE_DT, LWH.START_TIME, LWH.END_TIME";   
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("status", status);
		map.addValue("tutorSchdId", tutorSchdId);		
		List<AppointmentResponseDtls> schdDtls = jdbcTemplate.query(sql, map, new CandidateInfoRowMapper());
		return new ListMessage<>(schdDtls);		
	}

	public class CandidateInfoRowMapper implements RowMapper<AppointmentResponseDtls>{

		@Override
		public AppointmentResponseDtls mapRow(ResultSet rs, int rowNum)
				throws SQLException {

			AppointmentResponseDtls row = new AppointmentResponseDtls();
			row.setfName(rs.getString("FIRST_NAME"));
			row.setlName(rs.getString("LAST_NAME"));
			row.setProdName(rs.getString("PRODUCT_NAME"));
			row.setTutorName(rs.getString("TUTOR_NAME"));
			return row;
		}

	}
	
}

