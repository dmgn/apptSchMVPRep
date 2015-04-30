package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.TutorDao;
import app.cal.schedule.business.entity.Tutor;

public class DeleteTutorCommandHandler extends BaseCommandHandler<DeleteTutor>
		implements CommandHandler<DeleteTutor> {
	
	TutorDao tutorDao;
	
	public DeleteTutorCommandHandler() {}
	
	public DeleteTutorCommandHandler(TutorDao tutorDao){
		this.tutorDao = tutorDao;
	}

	@Override
	public void handle(HandlerContext ctx, DeleteTutor cmd) {
		final Tutor tutor = tutorDao.findTutorEntityByRefId(cmd.getReferenceId());
		tutorDao.delete(tutor);
		buildResponse(ctx, tutor, "Tutor info deleted successfully");
	}

}
