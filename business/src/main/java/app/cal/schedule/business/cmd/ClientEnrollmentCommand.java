package app.cal.schedule.business.cmd;

import java.util.Date;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientEnrollmentDetails;

public class ClientEnrollmentCommand extends BaseCommand {

	public ClientEnrollmentCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	protected ClientEnrollmentDetails getMsg(){
		return (ClientEnrollmentDetails)baseMsg;
	}
	
	public long getClientId(){
		return getMsg() == null ? null : getMsg().getClientId();
	}
	
	public long getProductId(){
		return getMsg() == null ? null : getMsg().getProductId();
	}
	
	public Date getInsertDate(){
		return getMsg() == null ? null : getMsg().getEnrolledDate();
	}
}
