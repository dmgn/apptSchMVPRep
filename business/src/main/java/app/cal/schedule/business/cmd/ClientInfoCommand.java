package app.cal.schedule.business.cmd;

import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientGroupDetails;
import app.cal.schedule.api.ClientInfoDetails;

public class ClientInfoCommand extends BaseCommand{

	public ClientInfoCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}
	
	protected ClientGroupDetails getMsg(){
		return (ClientGroupDetails)baseMsg;
	}
	
	public List<ClientInfoDetails> getClientInfo(){
		return getMsg() == null ? null : getMsg().getList() ;
	}
	
	public String getPrimContactNo() {
		return getMsg() == null ? null : getMsg().getPrimContactNo();
	}

	public String getSecContactNo() {
		return getMsg() == null ? null : getMsg().getSecContactNo();
	}

	public String getPrimParentEmailId() {
		return getMsg() == null ? null : getMsg().getPrimParentEmailId();
	}

	public String getSecParentEmailId() {
		return getMsg() == null ? null : getMsg().getSecParentEmailId();
	}
	

}
