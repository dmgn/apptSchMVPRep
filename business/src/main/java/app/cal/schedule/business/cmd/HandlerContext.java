package app.cal.schedule.business.cmd;

import java.util.Date;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.SystemNotification;

public interface HandlerContext {
	
	BaseMessage buildResponse();
	
	void addError( SystemNotification error );
	
	void addWarning( SystemNotification warn );
	
	void addInfo( SystemNotification info );
	
	void addReferenceId( String refId );
	
	void addNewVersion( int version );
	
	void addLastUpdated( Date date );
	
	boolean hasErrors();
}
