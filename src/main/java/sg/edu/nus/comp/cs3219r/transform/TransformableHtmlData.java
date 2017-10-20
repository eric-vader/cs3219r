package sg.edu.nus.comp.cs3219r.transform;

import java.util.List;

public interface TransformableHtmlData {

  public String openingTag();

  public String closingTag();

  public String data();

  /**
   * Convenient method to flatten the children. We will use this implementation
   * when there is no data in-between the tags.
   * 
   * @param children Child nodes that can be transformed.
   * @return Flattened Children.
   */
  public static String flattenChildren(List<TransformableHtmlData> children) {
    String childrenHtml = "";
    for (TransformableHtmlData eaChild : children) {
      childrenHtml += Transformer.toHtml(eaChild);
    }
    return childrenHtml;
  }

}
