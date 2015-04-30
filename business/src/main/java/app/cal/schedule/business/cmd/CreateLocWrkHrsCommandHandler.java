package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.LocationWrkHrsDao;
import app.cal.schedule.business.entity.LocationWorkHours;

public class CreateLocWrkHrsCommandHandler extends BaseCommandHandler<CreateLocWrkHrs> implements CommandHandler<CreateLocWrkHrs>{

	LocationWrkHrsDao locationWrkHrsDao;
	
	public CreateLocWrkHrsCommandHandler() {}
	
	public CreateLocWrkHrsCommandHandler( LocationWrkHrsDao locationWrkHrsDao ){
		this.locationWrkHrsDao = locationWrkHrsDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateLocWrkHrs cmd) {
		LocationWorkHours entity = new LocationWorkHours(cmd.getStartTime(),
				cmd.getEndTime(),
				cmd.getLocationId());
		locationWrkHrsDao.saveLocationWorkHoursEntity(entity);
		locationWrkHrsDao.flush();
		buildResponse(ctx, entity, "Location work hours saved successfully");
	}

}
