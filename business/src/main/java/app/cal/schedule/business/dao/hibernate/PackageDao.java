package app.cal.schedule.business.dao.hibernate;

import app.cal.schedule.business.entity.Package;


public interface PackageDao extends AggregateDataAccess<Package> {

	void savePackageEntity(Package pkg);
	
	void deletePackageEntityByRefId( Package pkg);
	
	Package findEntityByRefId( String refId );
}
