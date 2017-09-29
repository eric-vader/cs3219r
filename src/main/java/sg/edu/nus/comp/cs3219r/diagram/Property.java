package sg.edu.nus.comp.cs3219r.diagram;

import static sg.edu.nus.comp.cs3219r.diagram.Visibility.toVisibility;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represent a property in GoJS diagramming library.
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class Property {
  private String name;
  private String type;
  private Visibility visibility;

  public Property(final Field ea_field_java) {
    this.setName(ea_field_java.getName());
    this.setType(classString(ea_field_java));
    this.setVisibility(toVisibility(ea_field_java.getModifiers()));
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

  public Visibility getVisibility() {
    return visibility;
  }

  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }

  public static String classString(final Field ea_field_java) {
    if (Collection.class.isAssignableFrom(ea_field_java.getType())) {
      ParameterizedType integerListType =
          (ParameterizedType) ea_field_java.getGenericType();
      String classString = ea_field_java.getType().getSimpleName() + "<";
      String delim = "";
      for (java.lang.reflect.Type eaType : integerListType
          .getActualTypeArguments()) {
        Class<?> typeClass = (Class<?>) eaType;
        classString += typeClass.getSimpleName() + delim;
        delim = ",";
      }
      classString += ">";
      return classString;
    } else {
      return ea_field_java.getType().getSimpleName();
    }
  }

  public static boolean isAggregateType(Class<?> fromClass, Field toField) {
    if (fromClass.equals(toField.getType())) {
      return true;
    } else {
      if (Collection.class.isAssignableFrom(toField.getType())) {
        // Now we check the generics
        ParameterizedType integerListType =
            (ParameterizedType) toField.getGenericType();
        String classString = toField.getType().getSimpleName() + "<";
        String delim = "";
        for (java.lang.reflect.Type eaType : integerListType
            .getActualTypeArguments()) {
          Class<?> typeClass = (Class<?>) eaType;
          if (fromClass.equals(typeClass)) {
            return true;
          }
        }
      }
      return false;
    }
  }

}
