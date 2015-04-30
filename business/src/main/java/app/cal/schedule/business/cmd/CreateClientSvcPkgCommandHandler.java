package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientSvcPkgDao;
import app.cal.schedule.business.entity.ClientSvcPkgInfo;

public class CreateClientSvcPkgCommandHandler extends BaseCommandHandler<CreateClientSvcPkg>
		implements CommandHandler<CreateClientSvcPkg> {
	
	
	ClientSvcPkgDao clientSvcPkgDao;
	
	public CreateClientSvcPkgCommandHandler() {}

	public CreateClientSvcPkgCommandHandler(ClientSvcPkgDao clientSvcPkgDao) {
		this.clientSvcPkgDao = clientSvcPkgDao;
	}

	
	@Override
	public void handle(HandlerContext ctx, CreateClientSvcPkg cmd) {

		ClientSvcPkgInfo entity = new ClientSvcPkgInfo(cmd.getEnrollId(),
				cmd.getProductId(),
				cmd.getPackageId(),
				cmd.getPkgStartDate(),
				cmd.getPkgEndDate());
		clientSvcPkgDao.saveCSPIEntity(entity);
		clientSvcPkgDao.flush();
		buildResponse(ctx, entity, "Client service package saved successfully");
	}

}
