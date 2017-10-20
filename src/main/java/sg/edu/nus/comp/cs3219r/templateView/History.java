package sg.edu.nus.comp.cs3219r.templateView;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.comp.cs3219r.transform.HtmlTransformer;

public class History implements Template {

  private List<Event> events;

  public History() {
    this.events = new ArrayList<Event>();
    this.events.add(new Event(false, "Transform View"));
    this.events.add(new Event(false, "Template View"));
    this.events.add(new Event(true, "Application Controller"));
  }

  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  @Override
  public String key() {
    return "history";
  }

  @Override
  public String value() {
    return HtmlTransformer.toHtml(this);
  }

}
