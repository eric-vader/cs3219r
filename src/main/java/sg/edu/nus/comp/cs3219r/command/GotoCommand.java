package sg.edu.nus.comp.cs3219r.command;

import sg.edu.nus.comp.cs3219r.Utils;
import sg.edu.nus.comp.cs3219r.application.AppState;

public class GotoCommand extends Command {

	public GotoCommand() {
		super("Skip", "goto", "page");
		this.setHidden(true);
		for(String mId : Utils.markdownIds()) {
			this.addOption(Utils.markdownDisplayNames().get(mId), "page", mId);
		}
	}

	@Override
	public void execute(AppState state, String... parameters) {
		state.getMarkdown().update(parameters[0]);
		state.getCmdDir().get("next").setHidden(!state.getMarkdown().is_next());
		state.getCmdDir().get("prev").setHidden(!state.getMarkdown().is_prev());
	}

}
