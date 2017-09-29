package sg.edu.nus.comp.cs3219r.diagram;

public class Link {

  private int from;
  private int to;
  private Relationship relationship;

  public Link(Class<?> fromClass, Class<?> toClass) {
    this.from = fromClass.hashCode();
    this.to = toClass.hashCode();
    this.relationship = Relationship.toRelationship(fromClass, toClass);
    
  }

  public int getFrom() {
    return from;
  }

  public void setFrom(int from) {
    this.from = from;
  }

  public int getTo() {
    return to;
  }

  public void setTo(int to) {
    this.to = to;
  }

  public Relationship getRelationship() {
    return relationship;
  }

  public void setRelationship(Relationship relationship) {
    this.relationship = relationship;
  }

}
