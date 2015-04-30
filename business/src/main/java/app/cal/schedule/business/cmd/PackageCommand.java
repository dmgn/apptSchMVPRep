package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.PackageDetails;

public class PackageCommand extends BaseCommand {

	protected PackageCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}
	
	public String getPackageName(){
		return getMsg() == null ? null : getMsg().getPackageName();
	}
	
	public int getPackageDuration(){
		return getMsg() == null ? null : getMsg().getPackageDuration();
	}
	
	
	
	protected PackageDetails getMsg(){
		return (PackageDetails)baseMsg;
	}

	public String getPackageDesc(){
		return getMsg() == null ? null : getMsg().getPackageDesc();
	}
	
	public String getPackageOfferCode(){
		return getMsg() == null ? null : getMsg().getPackageOfferCode();
	}
}
