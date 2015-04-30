package app.cal.schedule.business.cmd;

import org.springframework.stereotype.Component;

import app.cal.schedule.business.dao.hibernate.ProductDao;
import app.cal.schedule.business.entity.Product;


@Component
public class DeleteProductCommandHandler extends BaseCommandHandler<DeleteProduct> {

	ProductDao productDao;
	
	public DeleteProductCommandHandler( ProductDao productDao ) {
		this.productDao = productDao;
				
	}

	@Override
	public void handle(HandlerContext ctx, DeleteProduct cmd) {
		Product prod = productDao.findEntityByRefId(cmd.getReferenceId());
		productDao.deleteProductEntityById( prod );
		buildResponse(ctx, prod, "Product deleted successfully");
	}
	
	public DeleteProductCommandHandler(){}

}
