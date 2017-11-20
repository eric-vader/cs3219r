package sg.edu.nus.comp.cs3219r.transform;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public interface HtmlTransformer<T> {

  static HashMap<Class<?>, Class<?>> registry = new HashMap<>();

  public static void register(Class<?> dataClazz, Class<?> transformerClazz) {
    registry.put(dataClazz, transformerClazz);
  }

  public static <T> HtmlTransformer<T> initTransformer(T obj) {

    try {
      Class<?> transformerClass = registry.get(obj.getClass());
      HtmlTransformer<T> transformer = (HtmlTransformer<T>) transformerClass
          .getDeclaredConstructor(obj.getClass()).newInstance(obj);
      return transformer;
    } catch (InstantiationException | IllegalAccessException
        | IllegalArgumentException | InvocationTargetException
        | NoSuchMethodException | SecurityException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Convenient method to flatten the children. We will use this implementation
   * when there is no data in-between the tags.
   * 
   * @param children Child nodes that can be transformed.
   * @return Flattened Children.
   */
  public static <T> String flattenChildren(List<T> children) {
    String childrenHtml = "";
    for (T eaChild : children) {
      childrenHtml += toHtml(eaChild);
    }
    return childrenHtml;
  }

  public static <T> String toHtml(T obj) {
    HtmlTransformer<T> e = HtmlTransformer.initTransformer(obj);
    return e.openingTag() + e.data() + e.closingTag();
  }

  public String openingTag();

  public String closingTag();

  public String data();


}
