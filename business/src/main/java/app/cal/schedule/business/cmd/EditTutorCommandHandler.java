package app.cal.schedule.business.cmd;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import app.cal.schedule.business.dao.hibernate.TutorDao;
import app.cal.schedule.business.entity.Tutor;
import app.cal.schedule.business.entity.TutorServiceMap;

public class EditTutorCommandHandler extends BaseCommandHandler<EditTutor> implements
		CommandHandler<EditTutor> {

	TutorDao tutorDao;
	
	public EditTutorCommandHandler() {}
	
	public EditTutorCommandHandler( TutorDao tutorDao ){
		this.tutorDao = tutorDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, EditTutor cmd) {
		final Tutor tutor = tutorDao.findTutorEntityByRefId(cmd.getReferenceId());
		//checkConcurrency(cmd.getExpectedVersion(), tutor.getVersion());
		
		Set<Long> cmdProductIds =  new HashSet<>(cmd.getProductIds());
		Set<Long> dbProductIds =  new HashSet<>();

		for(Iterator<TutorServiceMap> it = tutor.getTsMap().iterator(); it.hasNext();){
			TutorServiceMap element = it.next();
			dbProductIds.add(element.getProductId());
		}
		
		
		tutor.setTutorName(cmd.getTutorName());
		tutorDao.update(tutor);
		buildResponse(ctx, tutor, "Tutor info updated successfully");
	}

}
