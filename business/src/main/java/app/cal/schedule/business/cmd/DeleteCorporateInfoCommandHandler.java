package app.cal.schedule.business.cmd;

import app.cal.schedule.business.dao.hibernate.CorporateInfoDao;
import app.cal.schedule.business.entity.Corporate;

public class DeleteCorporateInfoCommandHandler extends BaseCommandHandler<DeleteCorporateInfo>
		implements CommandHandler<DeleteCorporateInfo> {

	CorporateInfoDao corporateInfoDao;

	public DeleteCorporateInfoCommandHandler() {}
	
	public DeleteCorporateInfoCommandHandler( CorporateInfoDao corporateInfoDao ){
		this.corporateInfoDao = corporateInfoDao;
	}
	
	@Override
	public void handle(HandlerContext ctx, DeleteCorporateInfo cmd) {
		Corporate corp = corporateInfoDao.findCorporateInfoByRefId(cmd.getReferenceId());
		corporateInfoDao.delete(corp);
		buildResponse(ctx, corp, "Corporate Info deleted succesfully");
	}

}
