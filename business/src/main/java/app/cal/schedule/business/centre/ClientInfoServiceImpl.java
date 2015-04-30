package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientGroupDetails;
import app.cal.schedule.api.ClientInfoDetails;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateClientInfo;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.ClientInfoReadDao;

public class ClientInfoServiceImpl extends BaseService implements
		ClientInfoService {

	ClientInfoReadDao clientInfoReadDao;
	
	public ClientInfoServiceImpl() {
	}

	public ClientInfoServiceImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			ClientInfoReadDao clientInfoReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.clientInfoReadDao = clientInfoReadDao;
	}
	
	@Override
	public BaseMessage addClientInfo(ClientGroupDetails cInfoDtls) {		
		final CreateClientInfo cmd = new CreateClientInfo(cInfoDtls);
		final CommandHandler<CreateClientInfo> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public BaseMessage deleteClientInfoByRefId(String refId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMessage updateClientInfo(ClientGroupDetails cInfoDtls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientInfoDetails findClientInfo(String refId) {
		return clientInfoReadDao.findClientByRefId(refId);
	}

	@Override
	public ListMessage<ClientInfoDetails> findAllClientsFor(long corpId) {
		return clientInfoReadDao.findAllClientsFor(corpId);
	}

	@Override
	public ClientInfoDetails findClientByEmailId(String emailId) {
		return clientInfoReadDao.findClientByEmailId(emailId);
	}

}
