package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientEnrollmentDao;
import app.cal.schedule.business.entity.ClientEnrollment;

public class CreateClientEnrollmentCommandHandler extends
		BaseCommandHandler<CreateClientEnrollment> implements CommandHandler<CreateClientEnrollment> {

	ClientEnrollmentDao clientEnrollmentDao;
	
	public CreateClientEnrollmentCommandHandler(){}
	
	public CreateClientEnrollmentCommandHandler( ClientEnrollmentDao clientEnrollmentDao ){
		this.clientEnrollmentDao = clientEnrollmentDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateClientEnrollment cmd) {

		final ClientEnrollment entity = new ClientEnrollment(cmd.getClientId(), cmd.getProductId());
		clientEnrollmentDao.saveClientEnrollmentEntity(entity);
		clientEnrollmentDao.flush();
		buildResponse(ctx, entity, "Client enrollment is successful");
	}

}
