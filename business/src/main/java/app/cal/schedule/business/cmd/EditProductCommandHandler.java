package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ProductDao;
import app.cal.schedule.business.entity.Product;

public class EditProductCommandHandler extends BaseCommandHandler<EditProduct> {

	ProductDao productDao;
	
	
	public EditProductCommandHandler( ProductDao productDao ){
		this.productDao = productDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, EditProduct cmd) {
		Product prod = productDao.findEntityByRefId(cmd.getReferenceId());
		//checkConcurrency(cmd.getExpectedVersion(), prod.getVersion()); // the command should pass the version in version json node
		prod.setUnitPrice(cmd.getProductUnitPrice());
		prod.setProductName(cmd.getProductName());
		productDao.update(prod);
		productDao.flush();
		buildResponse(ctx, prod, "Product updated successfully");
	}
	
	public EditProductCommandHandler() {}

}
