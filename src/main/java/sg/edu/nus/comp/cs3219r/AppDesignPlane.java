package sg.edu.nus.comp.cs3219r;

import java.util.Arrays;
import java.util.List;

import sg.edu.nus.comp.cs3219r.diagram.Diagram;

public class AppDesignPlane {

  private String id;
  private Diagram diagram;
  
  public AppDesignPlane(String id, Class<?>... classes) {
    this.id = id;
    this.diagram = new Diagram(Arrays.asList(classes));
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Diagram getDiagram() {
    return diagram;
  }

  public void setDiagram(Diagram diagram) {
    this.diagram = diagram;
  }
  
}
