package app.cal.schedule.business.cmd;

import java.util.Date;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientSvcPkgInfoDetails;

public class ClientSvcPkgCommand extends BaseCommand {

	protected ClientSvcPkgCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}	
	
	protected ClientSvcPkgInfoDetails getMsg(){
		return (ClientSvcPkgInfoDetails)baseMsg;
	}

	public long getCorpId() {
		return getMsg() == null ? null : getMsg().getCorpId();
	}
	
	public long getEnrollId() {
		return getMsg() == null ? null : getMsg().getEnrollId();
	}
	
	public long getPackageId() {
		return getMsg() == null ? null : getMsg().getPackageId();
	}
	
	public long getProductId() {
		return getMsg() == null ? null : getMsg().getProductId();
	}
	
	public Date getPkgEndDate() {
		return getMsg() == null ? null : getMsg().getPkgEndDate() ;
	}
	
	public Date getPkgStartDate() {
		return getMsg() == null ? null : getMsg().getPkgStartDate() ;
	}
	
}
