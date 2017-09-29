package sg.edu.nus.comp.cs3219r.diagram;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class Utils {

  public static String getTypeWithGenerics(Class<?> clazz) {
    if(Collection.class.isAssignableFrom(clazz)) {
      ParameterizedType integerListType = (ParameterizedType) clazz.getGenericSuperclass();
      Class<?> typeClass = (Class<?>) integerListType.getActualTypeArguments()[0];
      System.out.println(typeClass.getSimpleName());
      return typeClass.getSimpleName();
    } else {
      return clazz.getSimpleName();
    }
    
  }
  
}
