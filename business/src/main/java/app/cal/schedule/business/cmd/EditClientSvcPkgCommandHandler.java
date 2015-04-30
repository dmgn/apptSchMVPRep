package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.ClientSvcPkgDao;
import app.cal.schedule.business.entity.ClientSvcPkgInfo;

public class EditClientSvcPkgCommandHandler extends BaseCommandHandler<EditClientSvcPkg>
		implements CommandHandler<EditClientSvcPkg> {

	ClientSvcPkgDao clientSvcPkgDao;
	
	public EditClientSvcPkgCommandHandler() {}
	
	public EditClientSvcPkgCommandHandler(ClientSvcPkgDao clientSvcPkgDao) {
		this.clientSvcPkgDao = clientSvcPkgDao;		
	}

	@Override
	public void handle(HandlerContext ctx, EditClientSvcPkg cmd) {		
		ClientSvcPkgInfo entity = clientSvcPkgDao.findEntityByRefId(cmd.getReferenceId());
		//checkConcurrency(cmd.getExpectedVersion(), entity.getVersion());
		entity.setEndDate(cmd.getPkgEndDate());
		entity.setStartDate(cmd.getPkgStartDate());
		entity.setPackageId(cmd.getPackageId());
		entity.setProductId(cmd.getProductId());
		clientSvcPkgDao.update(entity);
		clientSvcPkgDao.flush();
		buildResponse(ctx, entity, "Client service package updated successfully");
	}

}
