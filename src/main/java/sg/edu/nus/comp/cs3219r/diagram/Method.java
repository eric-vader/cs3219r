package sg.edu.nus.comp.cs3219r.diagram;
/**
 * Represent a method in GoJS diagramming library.
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */

import static sg.edu.nus.comp.cs3219r.diagram.Visibility.toVisibility;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Method {
  private String name;
  private List<Parameter> parameters;
  private Visibility visibility;

  public Method(java.lang.reflect.Method ea_method_java) {
    // TODO Auto-generated constructor stub
    this.setName(ea_method_java.getName());
    this.setVisibility(toVisibility(ea_method_java.getModifiers()));

    List<Parameter> parameters = new ArrayList<Parameter>();
    List<Type[]> paramGenericTypes = new ArrayList<>();
    Type[] genericParameterTypes = ea_method_java.getGenericParameterTypes();
    for (int i = 0; i < genericParameterTypes.length; i++) {
      if (genericParameterTypes[i] instanceof ParameterizedType) {
        Type[] pp = ((ParameterizedType) genericParameterTypes[i])
            .getActualTypeArguments();
        paramGenericTypes.add(pp);
      } else {
        paramGenericTypes.add(new Type[] {});
      }
    }
    int i = 0;
    for (java.lang.reflect.Parameter ea_param_java : ea_method_java
        .getParameters()) {
      parameters.add(new Parameter(ea_param_java, paramGenericTypes.get(i)));
      i++;
    }
    this.setParameters(parameters);

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Parameter> getParameters() {
    return parameters;
  }

  public void setParameters(List<Parameter> parameters) {
    this.parameters = parameters;
  }

  public Visibility getVisibility() {
    return visibility;
  }

  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }

}
