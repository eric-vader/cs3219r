package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.command.GotoCommand;
import sg.edu.nus.comp.cs3219r.command.LoginCommand;
import sg.edu.nus.comp.cs3219r.command.LogoutCommand;

@RegisterData(clazz = { GotoCommand.class })
public class CommandParamTransformer implements HtmlTransformer<Command> {

	private Command cmd;
	private String childHtml;

	public CommandParamTransformer(Command cmd) {
		this.cmd = cmd;
	}

	public CommandParamTransformer(GotoCommand cmd) {
		this.cmd = cmd;
	}

	@Override
	public String openingTag() {
		return "<li class='nav-item dropdown'>"
				+ "<a class='nav-link dropdown-toggle' data-toggle='dropdown' href='#' role='button' aria-haspopup='true' aria-expanded='false'>"
				+ this.cmd.getDisplayName() + "</a><div class='dropdown-menu'>";
	}

	@Override
	public String closingTag() {
		return "</div></li>";
	}

	@Override
	public String data() {
		return HtmlTransformer.flattenChildren(cmd.getOptions());
	}

}
