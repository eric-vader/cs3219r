package sg.edu.nus.comp.cs3219r.templateView;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.comp.cs3219r.transform.TransformableHtmlData;
import sg.edu.nus.comp.cs3219r.transform.Transformer;

public class History extends Template implements TransformableHtmlData {
  
  private List<TransformableHtmlData> records;
  
  public History() {
    this.records = new ArrayList<TransformableHtmlData>();
    this.records.add(new HistoryRecord(false, "Transform View"));
    this.records.add(new HistoryRecord(false, "Template View"));
    this.records.add(new HistoryRecord(true, "Application Controller"));
  }

  @Override
  public String key() {
    return "history";
  }

  @Override
  public String value() {
    return Transformer.toHtml(this);
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
    return TransformableHtmlData.flattenChildren(this.records);
  }

}
