package app.cal.schedule.business.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.common.AppointmentStatus;

public class AppointmentResponseDtlsRowMapper implements RowMapper<AppointmentResponseDtls>{

	@Override
	public AppointmentResponseDtls mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		AppointmentResponseDtls row = new AppointmentResponseDtls();
		row.setEndTime(rs.getString("END_TIME"));
		row.setStartTime(rs.getString("START_TIME"));
		row.setStatus( rs.getInt("isAvailable") == 0 ? AppointmentStatus.UNAVAILABLE.getText() : AppointmentStatus.get(rs.getInt("isAvailable")).getText());
		row.setReqDate(rs.getDate("SCHEDULE_DT"));
		row.setTutorScheduleId(rs.getLong("TS_ID"));	
		row.setStartTime(rs.getString("START_TIME"));
		row.setEndTime(rs.getString("END_TIME"));
		row.setLocationId(rs.getLong("LOCATION_ID"));
		return row;
	}
	
}
