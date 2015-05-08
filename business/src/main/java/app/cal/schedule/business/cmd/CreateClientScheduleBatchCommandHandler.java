package app.cal.schedule.business.cmd;

import java.util.List;

import app.cal.schedule.api.AppointmentResponseDtls;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.business.dao.hibernate.ClientScheduleInfoDao;
import app.cal.schedule.business.entity.ClientScheduleInfo;
import app.cal.schedule.common.AppointmentStatus;

public class CreateClientScheduleBatchCommandHandler extends
		BaseCommandHandler<CreateClientScheduleBatch> implements CommandHandler<CreateClientScheduleBatch> {

	public ClientScheduleInfoDao clientScheduleInfoDao;
	
	public CreateClientScheduleBatchCommandHandler(ClientScheduleInfoDao clientScheduleInfoDao){
		this.clientScheduleInfoDao = clientScheduleInfoDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateClientScheduleBatch cmd) {		
		ListMessage<AppointmentResponseDtls> respListMsg = cmd.getBatchMsg();
		List<AppointmentResponseDtls> respList = respListMsg.getList();
		for( AppointmentResponseDtls temp : respList){
			ClientScheduleInfo csi = new ClientScheduleInfo(cmd.getClientId(), cmd.getGroupId(), temp.getTutorSchId(), temp.getReqDate(), false,
					AppointmentStatus.valueOf(temp.getStatus()).getCode());
			clientScheduleInfoDao.saveClientScheduleInfoEntity(csi);
		}
		clientScheduleInfoDao.flush();
	}

}
