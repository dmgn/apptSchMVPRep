package app.cal.schedule.business.centre;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.api.AppointmentScheduleDetails;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreateClientScheduleBatch;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.AppointmentScheduleReadDao;
import app.cal.schedule.common.AppointmentStatus;

public class AppointmentScheduleServiceImpl extends BaseService implements
		AppointmentScheduleService {

	
	private AppointmentScheduleReadDao apptSchReadDao;
	
	public AppointmentScheduleServiceImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			AppointmentScheduleReadDao apptSchReadDao ){
		super(commandHandlerFactory, handlerContextFactory);
		this.apptSchReadDao = apptSchReadDao;
	}
	
	public void fetchWeeklyScheduledAppointments() {
		// TODO Auto-generated method stub

	}

	public void fetchAvailableTimeSlotsByWeek(Date startDate) {
		// TODO Auto-generated method stub

	}

	public void cancelAppointment(String id) {
		// TODO Auto-generated method stub

	}

	public void markAppointmentAsComplete(String id) {
		// TODO Auto-generated method stub

	}

	public void notifyAllClientsByEmail() {
		// TODO Auto-generated method stub

	}

	public void notifyOneClientByEmail(int clientId) {
		// TODO Auto-generated method stub

	}

	public void notifyAllClientsBySMS() {
		// TODO Auto-generated method stub

	}

	public void notifyOneClientBySMS(int clientId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListMessage<AppointmentResponseDtls> findScheduleStatus(String emailId) {
		return apptSchReadDao.findScheduleStatus(emailId, 0, 0);
	}

	@Override
	public ListMessage<AppointmentResponseDtls> bookAppointments(AppointmentScheduleDetails apptSchdDtls) {

		List<Long> selectedDays = apptSchdDtls.getSelectedDays();
		StringBuilder sb = new StringBuilder();
		for (long n : selectedDays) { 
		    if (sb.length() > 0) sb.append(',');
		    sb.append(n);
		}
		List<AppointmentResponseDtls> unavailableSlots = new LinkedList<>();
		List<AppointmentResponseDtls> availableSlots = new LinkedList<>();
		Map<AppointmentScheduleKeys, AppointmentResponseDtls> distinctAvailableSlots = new HashMap<>();
		List<AppointmentResponseDtls> response = apptSchReadDao.bookAppointments(apptSchdDtls.getProductId(), apptSchdDtls.getStartDt(),
				apptSchdDtls.getEndDt(), apptSchdDtls.getLocId(), apptSchdDtls.getTimeSlotId(), sb.toString(),
				apptSchdDtls.getClientId(), apptSchdDtls.getGroupId());
		for( AppointmentResponseDtls resp : response ){			
			if( resp.getStatus().equalsIgnoreCase(AppointmentStatus.UNAVAILABLE.getText()) ){
				unavailableSlots.add(resp);
			}else{
				AppointmentScheduleKeys key = new AppointmentScheduleKeys();
				key.setScheduleDate(resp.getReqDate());
				key.setTimeSlotId(resp.getTimeSlotId());
				if(!distinctAvailableSlots.containsKey(key)){
					availableSlots.add(resp);
					distinctAvailableSlots.put(key, resp);
				}
			}			
		}
		CreateClientScheduleBatch cmd = new CreateClientScheduleBatch(new ListMessage<AppointmentResponseDtls>(availableSlots),
				apptSchdDtls.getClientId(), apptSchdDtls.getGroupId());
		CommandHandler<CreateClientScheduleBatch> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		unavailableSlots.addAll(availableSlots);
		return new ListMessage<AppointmentResponseDtls>(unavailableSlots);
	}

	@Override
	public ListMessage<AppointmentResponseDtls> findAllAppointments(int status) {
		return apptSchReadDao.findAllAppointments(status) ;
	}

	@Override
	public ListMessage<AppointmentResponseDtls> displayAppointmentsInCalView(
			String startDt, String endDt) {
		return apptSchReadDao.displayAppointmentsInCalView(startDt, endDt);
	}

	@Override
	public ListMessage<AppointmentResponseDtls> viewCandidatesForTimeSlot(
			long tutorSchdId) {
		return apptSchReadDao.viewCandidatesForTimeSlot(tutorSchdId);
	}
}
