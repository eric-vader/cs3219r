package sg.edu.nus.comp.cs3219r.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Part of the template class, to translate the 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class HtmlHelper {

  private HashMap<String, Template> templates;
  private String htmlFile;
  
  public HtmlHelper(Path basePath) throws IOException {
    htmlFile = new String(Files.readAllBytes(basePath));
  }
  
  /**
   * Registers template objects into this helper.
   * @param template Template to
   */
  public void register(Template template) {
    this.templates.put(template.key(), template);
  }
  
  public String render() {
    String replacedHtml = htmlFile;
    for (Template eaTemplate:templates.values()) {
      replacedHtml = replacedHtml.replaceAll("\\{\\{"+eaTemplate.key()+"\\}\\}", eaTemplate.value());
    }
    return replacedHtml;
  }

}
