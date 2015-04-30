package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.ProductDetails;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateProduct;
import app.cal.schedule.business.cmd.DeleteProduct;
import app.cal.schedule.business.cmd.EditProduct;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.ProductReadDao;

public class ProductServiceImpl extends BaseService implements ProductService {

	ProductReadDao productReadDao;
	
	public ProductServiceImpl( CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			ProductReadDao productReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.productReadDao = productReadDao;
	}
	
	public BaseMessage addProduct(ProductDetails productDtls) {
		final CreateProduct cmd = new CreateProduct(productDtls);
		final CommandHandler<CreateProduct> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();		
	}

	public BaseMessage deleteProductByRefId(String refId) {
		final BaseMessage baseMsg = new BaseMessage();
		baseMsg.setReferenceId(refId);
		final DeleteProduct cmd = new DeleteProduct( baseMsg );
		final CommandHandler<DeleteProduct> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();		
	}

	public BaseMessage updateProduct( ProductDetails productDtls ) {
		final EditProduct cmd = new EditProduct(productDtls);
		final CommandHandler<EditProduct> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();		
	}

	@Override
	public ProductDetails findProductByRefId(String refId) {
		ProductDetails prodDtls = productReadDao.findProductByRefId(refId);
		return prodDtls;
	}

	@Override
	public ListMessage<ProductDetails> findAllProducts(long corpId) {
		return productReadDao.findAllProductsFor(corpId);
	}

	@Override
	public ListMessage<ProductDetails> findProductsByTutorId(long tutorId) {
		return productReadDao.findAllProductsByTutorId(tutorId);
	}

	@Override
	public ListMessage<ProductDetails> findProductsByClientId(long clientId) {
		return productReadDao.findProductsByClientId(clientId);
	}	
}
