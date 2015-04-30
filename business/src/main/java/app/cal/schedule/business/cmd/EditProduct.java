package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ProductDetails;

public class EditProduct extends ProductCommand {

	public EditProduct(BaseMessage baseMsg) {
		super(baseMsg);
	}
	
	public String toString(){		
		return new StringBuilder(" A request was received to edit Product with name " )
		.append( ((ProductDetails)baseMsg).getProductName()  )
		.toString();
	}

}
