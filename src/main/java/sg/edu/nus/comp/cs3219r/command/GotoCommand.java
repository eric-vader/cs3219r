package sg.edu.nus.comp.cs3219r.command;

public class GotoCommand extends Command {

  public GotoCommand() {
    super("Skip", "goto", "Page Controller");
  }

  @Override
  public void rollback() {
  }

  @Override
  public void execute() {
  }

}
