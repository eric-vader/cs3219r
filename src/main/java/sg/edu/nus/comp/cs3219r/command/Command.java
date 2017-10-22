package sg.edu.nus.comp.cs3219r.command;

import java.util.Arrays;
import java.util.List;

public abstract class Command {
  
  private final String displayName;
  private final List<String> avaliableParameters;
  
  public Command(String displayName, String... avaliableParameters) {
    this.displayName = displayName;
    this.avaliableParameters = Arrays.asList(avaliableParameters);
  }
  
  public String getDisplayName() {
    return displayName;
  }

  public List<String> getAvaliableParameters() {
    return avaliableParameters;
  }
  
  public abstract void backward();
  public abstract void forward();
}
