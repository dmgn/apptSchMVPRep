package app.cal.schedule.business.dao.jdbc;

import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.PackageDetails;

public interface PackageReadDao {

	
	PackageDetails findPackageByRefId ( String refId );
	
	ListMessage<PackageDetails> findAllPackageFor( long corpId );
	
}
