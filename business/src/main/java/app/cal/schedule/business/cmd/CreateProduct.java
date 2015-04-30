package app.cal.schedule.business.cmd;

import app.cal.schedule.api.ProductDetails;

public class CreateProduct extends ProductCommand {

	public CreateProduct(ProductDetails prodDtls) {
		super(prodDtls);
	}

	public String toString(){		
		return new StringBuilder(" A request was received to create a Product with name " )
		.append( ((ProductDetails)baseMsg).getProductName()  )
		.toString();
	}
	

}
