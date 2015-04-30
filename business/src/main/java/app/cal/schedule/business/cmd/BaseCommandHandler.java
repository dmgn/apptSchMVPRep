package app.cal.schedule.business.cmd;

import app.cal.schedule.api.SystemNotification;
import app.cal.schedule.business.entity.AggregateRoot;

public abstract class BaseCommandHandler<Cmd extends Command> implements CommandHandler<Cmd> {

	protected BaseCommandHandler(){}
	
	protected void checkConcurrency(int expectedVersion, int actualVersion){
		if (expectedVersion != actualVersion){
			final String msg = "Concurrency violation. Expected version %s, actual version %s";
			throw new RuntimeException(String.format(msg, expectedVersion, actualVersion));
		}
	}
	
	protected <AR extends AggregateRoot> void buildResponse( HandlerContext ctx, AR aggregate, String msg ){
		
		ctx.addNewVersion(aggregate.getVersion());
		ctx.addReferenceId(aggregate.getRefId());
		ctx.addLastUpdated(aggregate.getLastUpdated());
		if ( msg != null && !ctx.hasErrors())
			ctx.addInfo( new SystemNotification( msg ) );
	}
}
