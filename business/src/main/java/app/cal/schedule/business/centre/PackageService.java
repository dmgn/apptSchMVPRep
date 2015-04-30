package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.PackageDetails;

public interface PackageService {

	BaseMessage addPackage( PackageDetails pkgDtls );
	
	BaseMessage deletePackageByRefId ( String refId );
	
	BaseMessage updatePackage( PackageDetails pkgDtls );
	
	ListMessage<PackageDetails> listPackages ( long corpId );
}
