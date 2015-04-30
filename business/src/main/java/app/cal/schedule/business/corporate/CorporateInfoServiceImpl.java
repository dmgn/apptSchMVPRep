package app.cal.schedule.business.corporate;

import java.util.Date;
import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorporateDetails;
import app.cal.schedule.business.centre.BaseService;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateCorporateInfo;
import app.cal.schedule.business.cmd.DeleteCorporateInfo;
import app.cal.schedule.business.cmd.EditCorporateInfo;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;

public class CorporateInfoServiceImpl extends BaseService implements CorporateInfoService {

	public CorporateInfoServiceImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory ){
		super(commandHandlerFactory, handlerContextFactory);
	}


	public BaseMessage setUpCorpLocation() {
		return null;
	}

	public BaseMessage setUpCorpInfo( CorporateDetails corpDtls ) {
		final CreateCorporateInfo cmd = new CreateCorporateInfo(corpDtls);
		final CommandHandler<CreateCorporateInfo> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	public List<BaseMessage> fetchDailyAppointmentsByLocation(String locationRefId) {
		return null;
	}

	public List<BaseMessage> fetchWeeklyAppointmentsByLocation(String locationRefId,
			Date startDate) {
		return null;
	}

	public void exportSummaryReportsToFile(String fileType) {
		// TODO Auto-generated method stub

	}

	public byte[] downloadReports(String fileRefId) {
		// TODO Auto-generated method stub
		return null;
	}

	public CorporateInfoServiceImpl(){}


	@Override
	public BaseMessage deleteCorpInfo(String refId) {
		BaseMessage msg = new BaseMessage();
		msg.setReferenceId(refId);
		DeleteCorporateInfo cmd = new DeleteCorporateInfo(msg);
		final CommandHandler<DeleteCorporateInfo> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}


	@Override
	public BaseMessage updateCorpInfo(CorporateDetails corpDtls) {
		final EditCorporateInfo cmd = new EditCorporateInfo(corpDtls);
		final CommandHandler<EditCorporateInfo> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}
}
