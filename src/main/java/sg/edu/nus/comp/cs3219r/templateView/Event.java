package sg.edu.nus.comp.cs3219r.templateView;

public class Event {

  private boolean isCurrent;
  private String recordName;
  
  public Event(boolean isCurrent, String commandName) {

    this.isCurrent = isCurrent;
    this.recordName = commandName;
  }

  public boolean isCurrent() {
    return isCurrent;
  }

  public void setCurrent(boolean isCurrent) {
    this.isCurrent = isCurrent;
  }

  public String getRecordName() {
    return recordName;
  }

  public void setRecordName(String recordName) {
    this.recordName = recordName;
  }

}
