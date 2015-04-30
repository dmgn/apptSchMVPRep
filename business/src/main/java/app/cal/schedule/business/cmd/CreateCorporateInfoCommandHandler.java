package app.cal.schedule.business.cmd;

import java.util.LinkedList;
import java.util.List;

import app.cal.schedule.api.CorpLocDetails;
import app.cal.schedule.business.dao.hibernate.CorporateInfoDao;
import app.cal.schedule.business.entity.Corporate;
import app.cal.schedule.business.entity.CorporateLocation;

public class CreateCorporateInfoCommandHandler extends BaseCommandHandler<CreateCorporateInfo>
		implements CommandHandler<CreateCorporateInfo> {

	CorporateInfoDao corporateInfoDao;
	
	public CreateCorporateInfoCommandHandler( CorporateInfoDao corporateInfoDao ) {
		this.corporateInfoDao = corporateInfoDao;
	}
	
	public CreateCorporateInfoCommandHandler() {}
	
	@Override
	public void handle(HandlerContext ctx, CreateCorporateInfo cmd) {
		final Corporate corp = new Corporate(cmd.getCorpName());
		List<CorporateLocation> corpLocList =  createCorpLocEntityList(cmd);
		for(CorporateLocation corpLoc : corpLocList){
			corpLoc.setCorp(corp);
		}
		corp.getCorpLocList().addAll(corpLocList);
		corporateInfoDao.saveCorporateEntity(corp);
		corporateInfoDao.flush();
		buildResponse(ctx, corp, "Corporate Info saved successfully");
	}

	public List<CorporateLocation> createCorpLocEntityList( CreateCorporateInfo cmd ){
		List<CorporateLocation> result = new LinkedList<>();
		List<CorpLocDetails> corpLocDtls = cmd.getCorpLocations();
		CorporateLocation entity = null;
		for(CorpLocDetails corpLoc : corpLocDtls){
			entity = new CorporateLocation(corpLoc.getStreet(),
					corpLoc.getCity(),
					corpLoc.getState(),
					corpLoc.getZipCode(),
					corpLoc.getTimezone(),
					corpLoc.getCountry());
			entity.auditChange();
			result.add(entity);
		}
		return result;
	}
	
}
