package sg.edu.nus.comp.cs3219r.command;

import sg.edu.nus.comp.cs3219r.application.AppState;

public class PrevCommand extends Command {

	public PrevCommand() {
		super("Prev", "prev");
		this.setHidden(true);
	}

	@Override
	public void execute(AppState state, String... parameters) {
		this.setHidden(!state.getMarkdown().prev_page());
		state.getCmdDir().get("next").setHidden(!state.getMarkdown().is_next());
	}

}
