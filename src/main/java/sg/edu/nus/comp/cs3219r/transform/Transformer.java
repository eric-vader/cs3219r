package sg.edu.nus.comp.cs3219r.transform;

public class Transformer {

  public static String toHtml(TransformableHtmlData e) {
    return e.openingTag() + e.data() + e.closingTag();

  }

}
