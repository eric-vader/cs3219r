package sg.edu.nus.comp.cs3219r.diagram;

import java.lang.reflect.Field;

public enum Relationship {
  _generalization,
  _aggregation,
  _noRel;
  
  public static Relationship toRelationship(Class<?> fromClass, Class<?> toClass) {
    if((!fromClass.equals(toClass)) && toClass.isAssignableFrom(fromClass)) {
      return _generalization;
    } else {
      for(Field eaField: toClass.getDeclaredFields()) {
        if(Property.isAggregateType(fromClass, eaField)) {
          return _aggregation;
        }
      }
    }
    return _noRel;
  }
  
}
