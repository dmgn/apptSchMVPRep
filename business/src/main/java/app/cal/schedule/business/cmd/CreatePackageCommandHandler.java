package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.PackageDao;
import app.cal.schedule.business.entity.Package;

public class CreatePackageCommandHandler extends BaseCommandHandler<CreatePackage> {

	PackageDao packageDao;
	
	public CreatePackageCommandHandler( PackageDao packageDao ) {
		this.packageDao = packageDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreatePackage cmd) {
		final Package pkg = new Package( cmd.getPackageName(), cmd.getPackageDuration(),cmd.getPackageOfferCode(), cmd.getPackageDesc(), cmd.getCorpId() ) ;
		packageDao.savePackageEntity(pkg);
		packageDao.flush();
		buildResponse(ctx, pkg, "Package saved successfully");
	}

	public CreatePackageCommandHandler() {
	}
}
