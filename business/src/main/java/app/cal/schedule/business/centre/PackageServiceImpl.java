package app.cal.schedule.business.centre;

import app.cal.schedule.api.BaseMessage;
import app.cal.schedule.api.ListMessage;
import app.cal.schedule.api.PackageDetails;
import app.cal.schedule.business.cmd.CommandHandler;
import app.cal.schedule.business.cmd.CommandHandlerFactory;
import app.cal.schedule.business.cmd.CreatePackage;
import app.cal.schedule.business.cmd.DeletePackage;
import app.cal.schedule.business.cmd.EditPackage;
import app.cal.schedule.business.cmd.HandlerContext;
import app.cal.schedule.business.cmd.HandlerContextFactory;
import app.cal.schedule.business.dao.jdbc.PackageReadDao;

public class PackageServiceImpl extends BaseService implements PackageService {

	PackageReadDao pkgReadDao;
	
	public PackageServiceImpl(CommandHandlerFactory commandHandlerFactory,
			HandlerContextFactory handlerContextFactory,
			PackageReadDao pkgReadDao){
		super(commandHandlerFactory, handlerContextFactory);
		this.pkgReadDao = pkgReadDao;
	}
	
	public BaseMessage addPackage(PackageDetails pkgDtls) {
		final CreatePackage cmd = new CreatePackage(pkgDtls);
		final CommandHandler<CreatePackage> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	public BaseMessage deletePackageByRefId(String refId) {
		final BaseMessage baseMsg = new BaseMessage();
		baseMsg.setReferenceId(refId);
		final DeletePackage cmd = new DeletePackage(baseMsg);
		final CommandHandler<DeletePackage> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();	
	}

	public BaseMessage updatePackage(PackageDetails pkgDtls) {
		EditPackage cmd = new EditPackage(pkgDtls);
		final CommandHandler<EditPackage> handler = commandHandlerFactory.findHandleFor(cmd);
		final HandlerContext ctx = handlerContextFactory.createContext();
		handler.handle(ctx, cmd);
		return ctx.buildResponse();
	}

	@Override
	public ListMessage<PackageDetails> listPackages(long corpId) {
		return pkgReadDao.findAllPackageFor(corpId);
	}

}
