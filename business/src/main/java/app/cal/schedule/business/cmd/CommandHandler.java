package app.cal.schedule.business.cmd;

public interface CommandHandler<Cmd extends Command> {

	void handle(HandlerContext ctx, Cmd cmd);
}
