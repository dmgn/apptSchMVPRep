package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.ProductDetails;

public interface ProductReadDao {

	ProductDetails findProductByRefId ( String refId );
	
	ListMessage<ProductDetails> findAllProductsFor( long corpId );
	
	ListMessage<ProductDetails> findAllProductsByTutorId( long tutorId );

	ListMessage<ProductDetails> findProductsByClientId(long clientId);
}
