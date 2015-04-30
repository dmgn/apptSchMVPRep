package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.PackageDetails;
import app.cal.schedule.api.ProductDetails;

public class EditPackage extends PackageCommand {

	public EditPackage(BaseMessage baseMsg) {
		super(baseMsg);
	}
	
	public String toString(){		
		return new StringBuilder(" A request was received to edit Package with name " )
		.append( ((PackageDetails)baseMsg).getPackageName()  )
		.toString();
	}
	

}
