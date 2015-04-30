package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.ProductDetails;


public interface ProductService {

	BaseMessage addProduct( ProductDetails productDtls );
	
	BaseMessage deleteProductByRefId( String refId );
	
	BaseMessage updateProduct( ProductDetails prodDtls );
	
	ProductDetails findProductByRefId ( String refId );
	
	ListMessage<ProductDetails> findAllProducts( long corpId );
	
	ListMessage<ProductDetails> findProductsByTutorId( long tutorId );
	
	ListMessage<ProductDetails> findProductsByClientId( long clientId );

}
