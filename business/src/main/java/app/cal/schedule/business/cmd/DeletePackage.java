package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.PackageDetails;

public class DeletePackage extends PackageCommand {

	public DeletePackage(BaseMessage baseMsg) {
		super(baseMsg);
	}
	
	public String toString(){		
		return new StringBuilder(" A request was received to delete a Package with name " )
		.append( ((PackageDetails)baseMsg).getPackageName()  )
		.toString();
	}
	

}
