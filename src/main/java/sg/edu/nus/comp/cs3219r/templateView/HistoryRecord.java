package sg.edu.nus.comp.cs3219r.templateView;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.comp.cs3219r.transform.TransformableHtmlData;

public class HistoryRecord implements TransformableHtmlData {

  private boolean isCurrent; 
  private String recordName;
  
  public HistoryRecord(boolean isCurrent, String commandName) {
    
    this.isCurrent = isCurrent;
    this.recordName = commandName;
    
  }
  
  @Override
  public String openingTag() {
    if(isCurrent) {
      return "<span class='breadcrumb-item active'>";
    } else {
      return "<a class='breadcrumb-item' href='#'>";
    }
  }

  @Override
  public String closingTag() {
    if(isCurrent) {
      return "</span>";
    } else {
      return "</a>";
    }
  }
  
  @Override
  public String data() {
    return this.recordName;
  }

}
