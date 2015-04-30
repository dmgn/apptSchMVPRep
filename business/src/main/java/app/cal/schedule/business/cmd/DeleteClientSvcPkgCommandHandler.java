package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientSvcPkgDao;
import app.cal.schedule.business.entity.ClientSvcPkgInfo;

public class DeleteClientSvcPkgCommandHandler extends BaseCommandHandler<DeleteClientSvcPkg>
		implements CommandHandler<DeleteClientSvcPkg> {
	
	ClientSvcPkgDao clientSvcPkgDao;
	
	public DeleteClientSvcPkgCommandHandler(ClientSvcPkgDao clientSvcPkgDao) {
		this.clientSvcPkgDao = clientSvcPkgDao;
	}

	@Override
	public void handle(HandlerContext ctx, DeleteClientSvcPkg cmd) {

		ClientSvcPkgInfo entity = clientSvcPkgDao.findEntityByRefId(cmd.getReferenceId());
		clientSvcPkgDao.deleteCSPIEntityByRefId(entity);
		clientSvcPkgDao.flush();
		buildResponse(ctx, entity, "Client service package deleted successfully ");
	}

}
