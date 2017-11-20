package sg.edu.nus.comp.cs3219r.command;

import sg.edu.nus.comp.cs3219r.application.AppState;

public class LoginCommand extends Command {

	public LoginCommand() {
		super("Login", "login", new String[] { "name" });
	}

	@Override
	public void execute(AppState state, String... parameters) {
		System.out.println("Login!");
		state.getCmdDir().get("goto").setHidden(false);
		state.getCmdDir().get("logout").setHidden(false);
		this.setHidden(true);
	}

}
