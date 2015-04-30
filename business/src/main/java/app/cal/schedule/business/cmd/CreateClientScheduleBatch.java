package app.cal.schedule.business.cmd;

import java.util.List;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;

public class CreateClientScheduleBatch extends ClientScheduleCommand {

	private long clientId;
	private long groupId;
	
	public CreateClientScheduleBatch(BaseMessage baseMsg, long clientId, long groupId) {
		super(baseMsg);
		this.clientId = clientId;
		this.groupId = groupId;
	}

	@SuppressWarnings("unchecked")
	public ListMessage<AppointmentResponseDtls> getBatchMsg(){		
		return (ListMessage<AppointmentResponseDtls>)baseMsg;
	}
	
	public List<AppointmentResponseDtls> getList(){
		return getBatchMsg().getList();
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	
}
