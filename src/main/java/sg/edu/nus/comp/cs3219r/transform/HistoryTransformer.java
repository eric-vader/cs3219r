package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.templateView.History;

@RegisterData(clazz = History.class)
public class HistoryTransformer implements HtmlTransformer<History> {
  
  private History history;
  
  public HistoryTransformer(History history) {
    this.history = history;
  }


  @Override
  public String openingTag() {
    return "<nav class='breadcrumb'>";
  }

  @Override
  public String closingTag() {
    return "</nav>";
  }
  
  @Override
  public String data() {
    return HtmlTransformer.flattenChildren(this.history.getEvents());
  }

}
