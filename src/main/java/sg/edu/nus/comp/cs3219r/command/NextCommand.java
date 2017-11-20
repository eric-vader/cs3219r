package sg.edu.nus.comp.cs3219r.command;

import sg.edu.nus.comp.cs3219r.application.AppState;

public class NextCommand extends Command {

	public NextCommand() {
		super("Next", "next");
		this.setHidden(true);
	}

	@Override
	public void execute(AppState state, String... parameters) {
		this.setHidden(!state.getMarkdown().next_page());
		state.getCmdDir().get("prev").setHidden(!state.getMarkdown().is_prev());
	}

}
