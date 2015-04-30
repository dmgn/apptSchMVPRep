package app.cal.schedule.business.cmd;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.cal.schedule.business.dao.hibernate.TutorScheduleDao;
import app.cal.schedule.business.entity.TutorSchedule;
import app.cal.schedule.common.ApplicationUtils;

public class CreateTutorScheduleCommandHandler extends BaseCommandHandler<CreateTutorSchedule>
		implements CommandHandler<CreateTutorSchedule> {

	TutorScheduleDao tutorScheduleDao;

	public CreateTutorScheduleCommandHandler() {
		
	}
	
	public CreateTutorScheduleCommandHandler(TutorScheduleDao tutorScheduleDao) {
		this.tutorScheduleDao = tutorScheduleDao;
	}
	

	
	@Override
	public void handle(HandlerContext ctx, CreateTutorSchedule cmd) {
		long tutorId = cmd.getTutorId();
		//long corpId = cmd.getCorpId();
		//long locationId = cmd.getLocationId();
		List<Long> timeSlotList = cmd.getTimeSlotIds();
		List<Long> prodIds = cmd.getProductIds();
		
		Date startDate = cmd.getStartDate();
		Date endDate = cmd.getEndDate();
		List<Date> dates = ApplicationUtils.getListofDates(startDate, endDate);
		
		Set<TutorSchedule> schSet = new HashSet<>();
		TutorSchedule tsEntity = null;
		
		
		for( Date dt : dates){
			for(Long timeSlotId : timeSlotList){
				for( Long prodId : prodIds){
					tsEntity = new TutorSchedule( tutorId, prodId, timeSlotId, dt);
					//tsEntity.auditChange();		
					schSet.add(tsEntity);
				}
			}
		}
		for( TutorSchedule tutorSchedule : schSet){
			tutorScheduleDao.saveNew(tutorSchedule);
			buildResponse(ctx, tutorSchedule, "Tutor Schedule saved successfully");	 

		}
		tutorScheduleDao.flush();	
	}

}
