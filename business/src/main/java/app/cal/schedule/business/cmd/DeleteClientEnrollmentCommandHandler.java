package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientGrpDao;

public class DeleteClientEnrollmentCommandHandler extends
		BaseCommandHandler<DeleteClientEnrollmentCommand> implements CommandHandler<DeleteClientEnrollmentCommand> {

	ClientGrpDao clientGrpDao;
	
	public DeleteClientEnrollmentCommandHandler() {}
	
	public DeleteClientEnrollmentCommandHandler(ClientGrpDao clientGrpDao){
		this.clientGrpDao = clientGrpDao;
	}
	
	
	@Override
	public void handle(HandlerContext ctx, DeleteClientEnrollmentCommand cmd) {
		
	}

}
