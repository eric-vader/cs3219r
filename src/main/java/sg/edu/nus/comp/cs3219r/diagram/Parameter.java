package sg.edu.nus.comp.cs3219r.diagram;

import java.lang.reflect.Type;
import java.util.StringJoiner;

/**
 * Represent a parameter in GoJS diagramming library.
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class Parameter {
  private String name;
  private String type;

  public Parameter(java.lang.reflect.Parameter ea_param_java,
      Type[] genericTypes) {

    String genericsStr = "";
    if (genericTypes.length > 0) {
      StringJoiner joiner = new StringJoiner(",");
      for (Type eaType : genericTypes) {
        if (eaType.getTypeName() != "?") {
          joiner.add(((Class<?>) eaType).getSimpleName());
        } else {
          joiner.add("?");
        }
      }
      genericsStr = "<" + joiner.toString() + ">";
    }
    this.setName(ea_param_java.getName());
    this.setType(ea_param_java.getType().getSimpleName() + genericsStr);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
