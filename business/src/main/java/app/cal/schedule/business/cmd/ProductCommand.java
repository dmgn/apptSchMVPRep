package app.cal.schedule.business.cmd;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ProductDetails;

public class ProductCommand extends BaseCommand {

	protected ProductCommand(BaseMessage baseMsg) {
		super(baseMsg);
	}

	public String getProductName(){
		return getMsg() == null ? null : getMsg().getProductName();
	}
	
	public Double getProductUnitPrice (){
		return getMsg() == null ? null : getMsg().getUnitPrice();
	}
	
	protected ProductDetails getMsg(){
		return (ProductDetails)baseMsg;
	}
	
	public long getCapacity(){
		return getMsg() == null ? null : getMsg().getCapacity();
	}
}
