package sg.edu.nus.comp.cs3219r.command;

import sg.edu.nus.comp.cs3219r.application.AppState;

public class GotoCommand extends Command {

  public GotoCommand() {
    super("Skip", "goto", "page");
    this.setHidden(false);
    this.addOption("Home", "page", "home");
    this.addOption("Page Controller", "page", "pageController");
  }

  @Override
  public void execute(AppState state, String... parameters) {
	  
  }

}
