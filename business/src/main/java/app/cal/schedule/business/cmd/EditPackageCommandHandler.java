package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.PackageDao;
import app.cal.schedule.business.entity.Package;

public class EditPackageCommandHandler extends BaseCommandHandler<EditPackage> {

	PackageDao packageDao;

	public EditPackageCommandHandler( PackageDao packageDao ) {
		this.packageDao = packageDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, EditPackage cmd) {
		Package pkg = packageDao.findEntityByRefId(cmd.getReferenceId());
		//checkConcurrency(cmd.getExpectedVersion(), pkg.getVersion());
		pkg.setPackageName(cmd.getPackageName());
		pkg.setPackageDuration(cmd.getPackageDuration());
		pkg.setPackageDesc(cmd.getPackageDesc());
		pkg.setPackageOfferCode(cmd.getPackageOfferCode());
		packageDao.update(pkg);
		packageDao.flush();
		buildResponse(ctx, pkg, "Package updated successfully");
	}

	public EditPackageCommandHandler() {}
}
