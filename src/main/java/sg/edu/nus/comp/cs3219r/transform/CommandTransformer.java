package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.command.Command;

@RegisterData(clazz=Command.class)
public class CommandTransformer implements HtmlTransformer<Command> {

  private Command cmd;
  
  public CommandTransformer(Command cmd) {
    this.cmd = cmd;
  }
  
  @Override
  public String openingTag() {
    return "<li class='nav-item active'><a class='nav-link' href='#'>";
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
