package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.TutorDetails;
import app.cal.schedule.api.TutorScheduleDetails;
import app.cal.schedule.api.TutorScheduleResponseDtls;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateTutor;
import app.cal.schedule.business.cmd.CreateTutorSchedule;
import app.cal.schedule.business.cmd.DeleteTutor;
import app.cal.schedule.business.cmd.DeleteTutorSchedule;
import app.cal.schedule.business.cmd.EditTutor;
import app.cal.schedule.business.cmd.EditTutorSchedule;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.TutorReadDao;

public class TutorServiceImpl extends BaseService implements TutorService {

	TutorReadDao tutorReadDao;
	
	public TutorServiceImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			TutorReadDao tutorReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.tutorReadDao = tutorReadDao;
	}
	
	public TutorServiceImpl() {}
	
	@Override
	public BaseMessage addTutor(TutorDetails tutorDtls) {
		final CreateTutor cmd = new CreateTutor(tutorDtls);
		final CommandHandler<CreateTutor> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();	
	}

	@Override
	public BaseMessage deleteTutorByRefId(String refId) {
		final BaseMessage msg = new BaseMessage();
		msg.setReferenceId(refId);
		final DeleteTutor cmd = new DeleteTutor(msg);
		final CommandHandler<DeleteTutor> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public BaseMessage updateTutor(TutorDetails tutorDtls) {
		final EditTutor cmd = new EditTutor(tutorDtls);
		final CommandHandler<EditTutor> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public TutorDetails findTutorByRefId(String refId) {
		return tutorReadDao.findTutorByRefId(refId);
	}

	@Override
	public ListMessage<TutorDetails> findAllTutorsFor(long corpId) {
		return tutorReadDao.findAllTutorsFor(corpId);
	}

	@Override
	public BaseMessage createTutorSchedule(TutorScheduleDetails tutSchDtls) {
		CreateTutorSchedule cmd = new CreateTutorSchedule(tutSchDtls);
		final CommandHandler<CreateTutorSchedule> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();	
	}

	@Override
	public BaseMessage updateTutorSchedule(TutorScheduleDetails tutSchDtls) {
		EditTutorSchedule cmd = new EditTutorSchedule(tutSchDtls);		
		final CommandHandler<EditTutorSchedule> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();	}

	@Override
	public BaseMessage deleteTutorScheduleByRefId(String refId) {
		final BaseMessage msg = new BaseMessage();
		msg.setReferenceId(refId);
		final DeleteTutorSchedule cmd = new DeleteTutorSchedule(msg);
		final CommandHandler<DeleteTutorSchedule> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public ListMessage<TutorScheduleResponseDtls> findTutorSchedule(long tutorId,
			long productId, long locationId) {
		return tutorReadDao.findTutorSchedule(tutorId, productId, locationId);
	}

	

	
}
