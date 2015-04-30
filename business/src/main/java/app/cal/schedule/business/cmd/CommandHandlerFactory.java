package app.cal.schedule.business.cmd;

public interface CommandHandlerFactory {

	<Cmd extends Command> CommandHandler <Cmd> findHandleFor( Cmd commandType );
	void register( String commandName, Object handler);
}
