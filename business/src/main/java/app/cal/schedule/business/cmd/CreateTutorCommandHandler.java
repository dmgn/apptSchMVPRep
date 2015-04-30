package app.cal.schedule.business.cmd;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.cal.schedule.business.dao.hibernate.TutorDao;
import app.cal.schedule.business.entity.Tutor;
import app.cal.schedule.business.entity.TutorServiceMap;

public class CreateTutorCommandHandler extends BaseCommandHandler<CreateTutor>
		implements CommandHandler<CreateTutor> {

	TutorDao tutorDao;
	
	public CreateTutorCommandHandler() {}
	
	public CreateTutorCommandHandler(TutorDao tutorDao){
		this.tutorDao = tutorDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, CreateTutor cmd) {
		final Tutor tutor = new Tutor(cmd.getTutorName(), cmd.getCorpId());
		Set<TutorServiceMap> set = createTutorServiceMapping(cmd, tutor);
		tutor.getTsMap().addAll(set);
		tutorDao.saveTutorEntity(tutor);
		tutorDao.flush();
		buildResponse(ctx, tutor, "Tutor info saved successfully");
	}

	private Set<TutorServiceMap> createTutorServiceMapping(CreateTutor cmd, Tutor tutor){
		List<Long> listOfProductIdIds = cmd.getProductIds();
		Set<TutorServiceMap> tutSvcMapppingSet = new HashSet<>();
		TutorServiceMap tutSvcMap = null;
		for( long productId : listOfProductIdIds ){
			tutSvcMap = new TutorServiceMap();
			tutSvcMap.setProductId(productId);
			tutSvcMap.setTutor(tutor);
			tutSvcMapppingSet.add(tutSvcMap);
		}		
		return tutSvcMapppingSet;		
	}
}
