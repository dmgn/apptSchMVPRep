package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientScheduleInfoDao;

public class DeleteClientScheduleInfoCommandHandler extends
		BaseCommandHandler<DeleteClientScheduleCommand> implements CommandHandler<DeleteClientScheduleCommand> {

	ClientScheduleInfoDao clientScheduleInfoDao;
	
	public DeleteClientScheduleInfoCommandHandler() {
	}
	
	public DeleteClientScheduleInfoCommandHandler( ClientScheduleInfoDao clientScheduleInfoDao ) {
		this.clientScheduleInfoDao = clientScheduleInfoDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, DeleteClientScheduleCommand cmd) {
		// TODO Auto-generated method stub
		
	}

}
