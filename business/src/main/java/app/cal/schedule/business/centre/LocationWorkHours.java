package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.LocationWrkHrsDtls;

public interface LocationWorkHours {

	BaseMessage addLocWrkHours( LocationWrkHrsDtls pkgDtls );
	
	BaseMessage deleteLocWrkHoursByRefId ( String refId );
	
	BaseMessage updateLocWrkHours( LocationWrkHrsDtls pkgDtls );
	
	ListMessage<LocationWrkHrsDtls> findLocWorkHourDtlsByCorpId (long corpId);
	
	ListMessage<LocationWrkHrsDtls> findLocWorkHourDtlsByLocId (long corpId, long locId);
	
	ListMessage<CorpLocDetails> findLocationByCorpId(long corpId);

}
