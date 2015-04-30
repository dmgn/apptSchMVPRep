package app.cal.schedule.business.cmd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class ContextAwareCommandHandlerFactory implements CommandHandlerFactory {

	
	private Map<String, CommandHandler<?>> registry = new ConcurrentHashMap<>();
	
	
	@SuppressWarnings("unchecked")
	public <Cmd extends Command> CommandHandler<Cmd> findHandleFor(
			Cmd commandType) {
		String commandName = commandType.getClass().getName();
		if( !registry.containsKey(commandName) )
			throw new RuntimeException( String.format( "Command %s is not registered", commandName ) );
		return (CommandHandler<Cmd>)registry.get(commandName);
	}

	public void register(String commandName, Object handler) {
		if( registry.containsKey(commandName) )
			throw new RuntimeException( String.format( "Command %s is already registered", commandName ) );
		registry.put(commandName, (CommandHandler<?>)handler);
	}

}
