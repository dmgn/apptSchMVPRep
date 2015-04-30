package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientSvcPkgInfoDetails;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateClientSvcPkg;
import app.cal.schedule.business.cmd.DeleteClientSvcPkg;
import app.cal.schedule.business.cmd.EditClientSvcPkg;
import app.cal.schedule.business.cmd.EditProduct;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.ClientSvcPkgReadDao;

public class ClientSvcPkgImpl extends BaseService implements ClientSvcPkg {

	private ClientSvcPkgReadDao clientSvcPkgReadDao;
	
	public ClientSvcPkgImpl() {}
	
	public ClientSvcPkgImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			ClientSvcPkgReadDao clientSvcPkgReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.clientSvcPkgReadDao = clientSvcPkgReadDao;
	}

	@Override
	public BaseMessage addClientSvcPkg(ClientSvcPkgInfoDetails cspiDtls) {
		final CreateClientSvcPkg cmd = new CreateClientSvcPkg(cspiDtls);
		final CommandHandler<CreateClientSvcPkg> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();	
	}

	@Override
	public BaseMessage deleteCSPIDtlsByRefId(String refId) {	
		final BaseMessage baseMsg = new BaseMessage();
		baseMsg.setReferenceId(refId);
		final DeleteClientSvcPkg cmd = new DeleteClientSvcPkg( baseMsg );
		final CommandHandler<DeleteClientSvcPkg> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();		
	}

	@Override
	public BaseMessage updateClientSvcPkg(ClientSvcPkgInfoDetails cspiDtls) {
		final EditClientSvcPkg cmd = new EditClientSvcPkg(cspiDtls);
		final CommandHandler<EditClientSvcPkg> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();	
	}

	@Override
	public ClientSvcPkgInfoDetails findPkgDtlsForProductByClientId(long corpId,
			long prodId, long clientId) {
		return clientSvcPkgReadDao.findPkgDtlsForProductByClientId(corpId, prodId, clientId);
	}

}
