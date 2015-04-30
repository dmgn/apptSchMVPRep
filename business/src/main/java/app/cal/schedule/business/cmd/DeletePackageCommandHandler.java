package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.PackageDao;
import app.cal.schedule.business.entity.Package;

public class DeletePackageCommandHandler extends BaseCommandHandler<DeletePackage> {

	PackageDao packageDao;

	@Override
	public void handle(HandlerContext ctx, DeletePackage cmd) {
		Package pkg = packageDao.findEntityByRefId(cmd.getReferenceId());
		packageDao.delete(pkg);
		buildResponse(ctx, pkg, "Package deleted successfully");
	}
	
	public DeletePackageCommandHandler( PackageDao packageDao ) {
		this.packageDao = packageDao;
	}
	
	public DeletePackageCommandHandler() {}
}
