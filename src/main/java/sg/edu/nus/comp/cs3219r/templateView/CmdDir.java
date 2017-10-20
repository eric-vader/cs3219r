package sg.edu.nus.comp.cs3219r.templateView;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.transform.HtmlTransformer;

public class CmdDir implements Template {
  
  private String dirName;
  private List<Command> commands;
  
  public CmdDir() {
    this.dirName = "CS3219R Tutorial";
    this.commands = new ArrayList<Command>();
    this.commands.add(new Command("Cmd1"));
    this.commands.add(new Command("Cmd2"));
    this.commands.add(new Command("Cmd3"));
  }
  
  public String getDirName() {
    return dirName;
  }

  public void setDirName(String dirName) {
    this.dirName = dirName;
  }

  
  
  public List<Command> getCommands() {
    return commands;
  }

  public void setCommands(List<Command> commands) {
    this.commands = commands;
  }

  @Override
  public String key() {
    return "nav";
  }

  @Override
  public String value() {
    return HtmlTransformer.toHtml(this);
  }
}