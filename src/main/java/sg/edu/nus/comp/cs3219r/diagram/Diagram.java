package sg.edu.nus.comp.cs3219r.diagram;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class Diagram {

  private List<Node> nodes;
  private List<Link> links;

  public Diagram(final List<Class<?>> classes) {
    List<Node> nodes = new ArrayList<Node>();
    List<Link> links = new ArrayList<Link>();
    for(Class<?> eaClass:classes) {
      nodes.add(new Node(eaClass));
      // Now check if this class has relation with the rest
      for(Class<?> eaClassOther:classes) {
        Link eaLink = new Link(eaClass, eaClassOther);
        if(eaLink.getRelationship()!= Relationship._noRel) {
          links.add(eaLink);
        }
      }
    }
    // We check for every 2 nodes, what is the relation
    
    this.setLinks(links);
    this.setNodes(nodes);
  }
  
  public List<Node> getNodes() {
    return nodes;
  }

  public void setNodes(List<Node> nodes) {
    this.nodes = nodes;
  }

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }
  
}
