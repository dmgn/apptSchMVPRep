package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ClientEnrollmentDetails;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateClientEnrollment;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.ClientEnrollmentReadDao;

public class ClientEnrollmentServiceImpl extends BaseService implements ClientEnrollmentService {

	ClientEnrollmentReadDao clientEnrollmentReadDao;
	
	public ClientEnrollmentServiceImpl(){}
	
	public ClientEnrollmentServiceImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			ClientEnrollmentReadDao clientEnrollmentReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.clientEnrollmentReadDao = clientEnrollmentReadDao;
	}
	
	
	@Override
	public BaseMessage addClientEnrollmentInfo(ClientEnrollmentDetails cInfoDtls) {
		CreateClientEnrollment cmd = new CreateClientEnrollment(cInfoDtls);
		CommandHandler<CreateClientEnrollment> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public BaseMessage deleteClientEnrollmentByRefId(String refId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMessage updateClientEnrollment(ClientEnrollmentDetails cInfoDtls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientEnrollmentDetails findClientEnrollment(String refId) {
		return clientEnrollmentReadDao.findEnrollmentByRefId(refId);
	}

}
