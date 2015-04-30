package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.TutorScheduleDao;
import app.cal.schedule.business.entity.TutorSchedule;

public class EditTutorScheduleCommandHandler extends BaseCommandHandler<EditTutorSchedule>
		implements CommandHandler<EditTutorSchedule> {

	TutorScheduleDao tutorScheduleDao;

	public EditTutorScheduleCommandHandler() {}
	
	public EditTutorScheduleCommandHandler(TutorScheduleDao tutorScheduleDao) {
		this.tutorScheduleDao = tutorScheduleDao;
	}
	
	
	@Override
	public void handle(HandlerContext ctx, EditTutorSchedule cmd) {

		TutorSchedule tutorSchedule = tutorScheduleDao.findTutorScheduleEntityByRefId(cmd.getReferenceId());
		tutorSchedule.setTimeSlotId(cmd.getTimeSlotIds().get(0));;
		tutorSchedule.setTutorId(cmd.getTutorId());
		tutorSchedule.setProductId(cmd.getProductIds().get(0));
		tutorScheduleDao.update(tutorSchedule);
		tutorScheduleDao.flush();
		buildResponse(ctx, tutorSchedule, "Tutor schedule updated successfully");
	}

}
