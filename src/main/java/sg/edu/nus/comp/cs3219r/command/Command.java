package sg.edu.nus.comp.cs3219r.command;

import java.util.Observable;
import java.util.Observer;

import javax.xml.transform.Templates;

import sg.edu.nus.comp.cs3219r.templateView.Template;

public class Command implements Observer {
  
  private String displayName;
  
  public Command(String displayName) {
    this.displayName = displayName;
  }
  
  @Override
  public void update(Observable arg0, Object arg1) {
    // TODO Auto-generated method stub
    
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

}
