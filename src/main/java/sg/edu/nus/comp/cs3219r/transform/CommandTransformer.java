package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.command.GotoCommand;
import sg.edu.nus.comp.cs3219r.command.LoginCommand;
import sg.edu.nus.comp.cs3219r.command.LogoutCommand;

@RegisterData(clazz={LogoutCommand.class})
public class CommandTransformer implements HtmlTransformer<Command> {

  private Command cmd;
  private String childHtml;
  
  public CommandTransformer(Command cmd) {
    this.cmd = cmd;
  }
  
  public CommandTransformer(LogoutCommand cmd) {
    this.cmd = cmd;
    childHtml = "<a class='nav-link' href='?cmd=logout'>";
  }
  
  @Override
  public String openingTag() {
    return "<li class='nav-item'>"+childHtml;
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
