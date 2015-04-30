package app.cal.schedule.business.centre;

import java.util.List;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.LocationWrkHrsDtls;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateLocWrkHrs;
import app.cal.schedule.business.cmd.DelLocWrkHrs;
import app.cal.schedule.business.cmd.EditLocWrkHrs;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.LocationWorkHoursReadDao;

public class LocationWorkHoursImpl extends BaseService implements
		LocationWorkHours {

	LocationWorkHoursReadDao locWrkHrsReadDao;
	
	public LocationWorkHoursImpl() {
	}
	
	public LocationWorkHoursImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			LocationWorkHoursReadDao locWrkHrsReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.locWrkHrsReadDao = locWrkHrsReadDao;
	}
	
	@Override
	public BaseMessage addLocWrkHours(LocationWrkHrsDtls locWHrsDtls) {
		final CreateLocWrkHrs cmd = new CreateLocWrkHrs(locWHrsDtls);
		final CommandHandler<CreateLocWrkHrs> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public BaseMessage deleteLocWrkHoursByRefId(String refId) {
		final BaseMessage baseMsg = new BaseMessage();
		baseMsg.setReferenceId(refId);
		final DelLocWrkHrs cmd = new DelLocWrkHrs(baseMsg);
		final CommandHandler<DelLocWrkHrs> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public BaseMessage updateLocWrkHours(LocationWrkHrsDtls locWHrsDtls) {
		EditLocWrkHrs cmd = new EditLocWrkHrs(locWHrsDtls);
		final CommandHandler<EditLocWrkHrs> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public ListMessage<LocationWrkHrsDtls> findLocWorkHourDtlsByCorpId( long corpId) {
			return locWrkHrsReadDao.findWorkHoursForAllLocations(corpId);		
	}

	@Override
	public ListMessage<LocationWrkHrsDtls> findLocWorkHourDtlsByLocId(
			long corpId, long locId) {
		return locWrkHrsReadDao.findLocationWorkHours(corpId, locId);
	}

	@Override
	public ListMessage<CorpLocDetails> findLocationByCorpId(long corpId) {
		return locWrkHrsReadDao.findAllLocations(corpId);
	}

}
