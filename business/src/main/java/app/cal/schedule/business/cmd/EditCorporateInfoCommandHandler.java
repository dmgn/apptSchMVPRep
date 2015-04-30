package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.CorporateInfoDao;
import app.cal.schedule.business.entity.Corporate;

public class EditCorporateInfoCommandHandler extends BaseCommandHandler<EditCorporateInfo>
		implements CommandHandler<EditCorporateInfo> {

	CorporateInfoDao corporateInfoDao;
	
	public EditCorporateInfoCommandHandler() {}
	
	public EditCorporateInfoCommandHandler(CorporateInfoDao corporateInfoDao){
		this.corporateInfoDao = corporateInfoDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, EditCorporateInfo cmd) {
		Corporate corp = corporateInfoDao.findCorporateInfoByRefId(cmd.getReferenceId());
		//checkConcurrency(cmd.getExpectedVersion(), corp.getVersion());
		corp.setCorpName(cmd.getCorpName());
		corporateInfoDao.update(corp);
		corporateInfoDao.flush();
		buildResponse(ctx, corp, "Corporate info updated successfully");
	}

}
