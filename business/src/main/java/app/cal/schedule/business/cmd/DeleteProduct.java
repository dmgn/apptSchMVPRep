package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ProductDetails;

public class DeleteProduct extends ProductCommand {

	public DeleteProduct(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public String toString(){		
		return new StringBuilder(" A request was received to delete a Product with name " )
		.append( ((ProductDetails)baseMsg).getProductName()  )
		.toString();
	}
}
