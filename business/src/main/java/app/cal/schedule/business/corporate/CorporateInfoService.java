package app.cal.schedule.business.corporate;

import java.util.Date;
import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorporateDetails;

public interface CorporateInfoService {

	BaseMessage setUpCorpLocation(/* CorpLocation */);
	
	BaseMessage setUpCorpInfo( CorporateDetails corpDtls );
	
	BaseMessage deleteCorpInfo( String refId );
	
	BaseMessage updateCorpInfo( CorporateDetails corpDtls );
	
	List<BaseMessage> fetchDailyAppointmentsByLocation(String locationRefId);
	
	List<BaseMessage> fetchWeeklyAppointmentsByLocation(String locationRefId, Date startDate);
	
	void exportSummaryReportsToFile( String fileType); // Email batch job? Recipients?
	
	byte[] downloadReports( String fileRefId);
}

