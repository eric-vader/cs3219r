package sg.edu.nus.comp.cs3219r.command;

import java.util.Arrays;
import java.util.List;

public abstract class Command {
  
  private final String displayName;
  private final String id;
  private final List<String> avaliableParameters;
  
  public Command(String displayName, String id, String... avaliableParameters) {
    this.displayName = displayName;
    this.id = id;
    this.avaliableParameters = Arrays.asList(avaliableParameters);
  }
  
  public String getDisplayName() {
    return displayName;
  }

  public List<String> getAvaliableParameters() {
    return avaliableParameters;
  }
  
  public abstract void rollback();
  public abstract void execute();
}
