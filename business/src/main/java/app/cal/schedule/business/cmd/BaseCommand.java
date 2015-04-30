package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;

public class BaseCommand implements Command {

	public final BaseMessage baseMsg;
	
	protected BaseCommand( BaseMessage baseMsg ){
		this.baseMsg = baseMsg;
	}
	
	public int getExpectedVersion() {
		return baseMsg.getVersion();
	}

	public String getRequestId(){
		return baseMsg.getRequestId();
	}
	
	public String getReferenceId(){
		return baseMsg.getReferenceId();		
	}
	
	public int getSource(){
		return baseMsg.getSource();
	}
	
	public long getCorpId(){
		return baseMsg.getCorpId();
	}
}
