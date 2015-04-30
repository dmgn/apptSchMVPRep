package app.cal.schedule.business.dao.sp;

import java.sql.Types;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import app.cal.schedule.api.AppointmentResponseDtls;
public class StoredProcGetTimeSlotDetails extends StoredProcedure{

	public StoredProcGetTimeSlotDetails(){
		
	}
	
	public StoredProcGetTimeSlotDetails(JdbcTemplate jdbcTemplate){
		super(jdbcTemplate, "GET_TIME_SLOT_DETAILS");
		RowMapper<AppointmentResponseDtls> rowMapper = new AppointmentResponseDtlsRowMapper();
		declareParameter(new SqlReturnResultSet("ResultList",rowMapper));
		declareParameter(new SqlParameter("P_START_DT", Types.DATE));
		declareParameter(new SqlParameter("P_END_DT", Types.DATE));
		declareParameter(new SqlParameter("P_TIME_SLOT_ID", Types.INTEGER));
		declareParameter(new SqlParameter("P_PROD_ID", Types.INTEGER));
		declareParameter(new SqlParameter("P_SELECTED_DAYS", Types.VARCHAR));
		compile();
	}

}
