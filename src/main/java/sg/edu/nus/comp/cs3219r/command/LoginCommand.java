package sg.edu.nus.comp.cs3219r.command;

import sg.edu.nus.comp.cs3219r.application.AppState;

public class LoginCommand extends Command {

	public LoginCommand() {
		super("Login", "login", new String[] { "name" });
	}

	@Override
	public void execute(AppState state, String... parameters) {
		state.getCmdDir().get("goto").setHidden(false);
		state.getCmdDir().get("next").setHidden(!state.getMarkdown().is_next());
		state.getCmdDir().get("prev").setHidden(!state.getMarkdown().is_prev());
		state.getCmdDir().get("logout").setHidden(false);
		this.setHidden(true);
	}

}
