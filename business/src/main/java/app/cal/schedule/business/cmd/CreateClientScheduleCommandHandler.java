package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientScheduleInfoDao;
import app.cal.schedule.business.entity.ClientScheduleInfo;
import app.cal.schedule.common.AppointmentStatus;

public class CreateClientScheduleCommandHandler extends BaseCommandHandler<CreateClientSchedule> 
implements CommandHandler<CreateClientSchedule>{

	public ClientScheduleInfoDao clientScheduleInfoDao;
	
	public CreateClientScheduleCommandHandler(ClientScheduleInfoDao clientScheduleInfoDao) {
		this.clientScheduleInfoDao = clientScheduleInfoDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateClientSchedule cmd) {
		ClientScheduleInfo clientSchdInfo = new ClientScheduleInfo(cmd.getClientId(), cmd.getGroupId(),
				cmd.getTutorScheduleId(), cmd.getStartDt(), cmd.isRecurring(), AppointmentStatus.valueOf(cmd.getStatus()).getCode() );
		clientScheduleInfoDao.saveClientScheduleInfoEntity(clientSchdInfo);
		clientScheduleInfoDao.flush();
		buildResponse(ctx, clientSchdInfo, "Client schedule saved successfully");
	}

}
