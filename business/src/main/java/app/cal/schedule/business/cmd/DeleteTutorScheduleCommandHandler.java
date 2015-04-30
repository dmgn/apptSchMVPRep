package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.TutorScheduleDao;
import app.cal.schedule.business.entity.TutorSchedule;

public class DeleteTutorScheduleCommandHandler extends BaseCommandHandler<DeleteTutorSchedule>
		implements CommandHandler<DeleteTutorSchedule> {

	TutorScheduleDao tutorScheduleDao;
	
	public DeleteTutorScheduleCommandHandler() {}
	
	public DeleteTutorScheduleCommandHandler( TutorScheduleDao tutorScheduleDao ) {
		this.tutorScheduleDao = tutorScheduleDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, DeleteTutorSchedule cmd) {
		TutorSchedule tutorSchedule = tutorScheduleDao.findById(cmd.getTutorScheduleId(), TutorSchedule.class);
		tutorScheduleDao.deleteTutorSchedule(tutorSchedule);
		buildResponse(ctx, tutorSchedule, "Tutor Schedule deleted successfully");
	}

}
