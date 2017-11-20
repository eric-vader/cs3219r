package sg.edu.nus.comp.cs3219r.templateView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.command.GotoCommand;
import sg.edu.nus.comp.cs3219r.command.LoginCommand;
import sg.edu.nus.comp.cs3219r.command.LogoutCommand;
import sg.edu.nus.comp.cs3219r.command.NextCommand;
import sg.edu.nus.comp.cs3219r.command.PrevCommand;
import sg.edu.nus.comp.cs3219r.transform.HtmlTransformer;

public class CmdDir implements Template {

	private String dirName;
	private Map<String, Command> cmdById;

	public CmdDir(String dirName) {
		this.dirName = dirName;
		this.cmdById = new HashMap<String, Command>();
		this.add(new LoginCommand());
		this.add(new GotoCommand());
		this.add(new LogoutCommand());
		this.add(new NextCommand());
		this.add(new PrevCommand());
	}

	private void add(Command cmd) {
		this.cmdById.put(cmd.getId(), cmd);
	}
	
	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public List<Command> getCommands() {
		return cmdById.values().stream()
				.filter(c -> !c.isHidden())
				.sorted((o1,o2) -> o1.getDisplayName().compareTo(o2.getDisplayName()))
				.collect(Collectors.toList());
	}

	@Override
	public String key() {
		return "nav";
	}

	@Override
	public String value() {
		return HtmlTransformer.toHtml(this);
	}

	public Command get(String cmd) {
		return this.cmdById.get(cmd);
	}
}
