package app.cal.schedule.business.cmd;

import org.springframework.stereotype.Component;
import app.cal.schedule.business.dao.hibernate.ProductDao;
import app.cal.schedule.business.entity.Product;

@Component
public class CreateProductCommandHandler extends BaseCommandHandler<CreateProduct> {

	ProductDao productDao;
	
	public CreateProductCommandHandler(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateProduct cmd) {		
		final Product prod = new Product(cmd.getProductName(), cmd.getProductUnitPrice(), cmd.getCorpId(), cmd.getCapacity() );
		productDao.saveProductEntity(prod);
		productDao.flush();
		buildResponse(ctx, prod, "Product saved successfully");
	}

	public CreateProductCommandHandler(){}
}
