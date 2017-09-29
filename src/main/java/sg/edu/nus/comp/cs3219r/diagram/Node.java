package sg.edu.nus.comp.cs3219r.diagram;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Node in GoJS diagramming library.
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class Node {

  private int key;
  private String name;
  private List<Property> properties;
  private List<Method> methods;

  public Node(Class<?> clazz) {
    this.setName(clazz.getSimpleName());
    this.setKey(clazz.hashCode());

    List<Property> properties = new ArrayList<Property>();
    this.setProperties(properties);
    for (Field ea_field_java : clazz.getDeclaredFields()) {
      properties.add(new Property(ea_field_java));
    }

    List<Method> methods = new ArrayList<Method>();
    this.setMethods(methods);
    for (java.lang.reflect.Method ea_method_java : clazz.getDeclaredMethods()) {

      Method ea_method = new Method(ea_method_java);
      methods.add(ea_method);
    }
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Property> getProperties() {
    return properties;
  }

  public void setProperties(List<Property> properties) {
    this.properties = properties;
  }

  public List<Method> getMethods() {
    return methods;
  }

  public void setMethods(List<Method> methods) {
    this.methods = methods;
  }

}
