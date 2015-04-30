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
	
}
