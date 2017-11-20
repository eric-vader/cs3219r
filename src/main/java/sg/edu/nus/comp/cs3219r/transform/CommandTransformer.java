package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.command.GotoCommand;
import sg.edu.nus.comp.cs3219r.command.LoginCommand;
import sg.edu.nus.comp.cs3219r.command.LogoutCommand;
import sg.edu.nus.comp.cs3219r.command.NextCommand;
import sg.edu.nus.comp.cs3219r.command.PrevCommand;

@RegisterData(clazz={LogoutCommand.class, NextCommand.class, PrevCommand.class})
public class CommandTransformer implements HtmlTransformer<Command> {

  private Command cmd;
  
  public CommandTransformer(Command cmd) {
    this.cmd = cmd;
  }

  public CommandTransformer(PrevCommand cmd) {
    this.cmd = cmd;
  }
  
  public CommandTransformer(NextCommand cmd) {
    this.cmd = cmd;
  }
  
  public CommandTransformer(LogoutCommand cmd) {
    this.cmd = cmd;
  }
  
  @Override
  public String openingTag() {
    return String.format("<li class='nav-item'><a class='nav-link' href='?cmd=%s'>", this.cmd.getId());
  }

  @Override
  public String closingTag() {
    return "</a></li>";
  }

  @Override
  public String data() {
    return this.cmd.getDisplayName();
  }

}
