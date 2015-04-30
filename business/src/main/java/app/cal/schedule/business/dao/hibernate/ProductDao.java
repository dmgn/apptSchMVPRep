package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.Product;

public interface ProductDao extends AggregateDataAccess<Product> {

	void saveProductEntity( Product svc );
	
	void deleteProductEntityById( Product product );
	
	Product findEntityByRefId( String refId );
}
