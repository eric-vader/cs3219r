package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.templateView.Event;

@RegisterData(clazz = Event.class)
public class EventTransformer implements HtmlTransformer<Event> {

  private Event event;

  public EventTransformer(Event event) {
    this.event = event;
  }

  @Override
  public String openingTag() {
    if (event.isCurrent()) {
      return "<span class='breadcrumb-item active'>";
    } else {
      return "<a class='breadcrumb-item' href='#'>";
    }
  }

  @Override
  public String closingTag() {
    if (event.isCurrent()) {
      return "</span>";
    } else {
      return "</a>";
    }
  }

  @Override
  public String data() {
    return event.getRecordName();
  }

}
