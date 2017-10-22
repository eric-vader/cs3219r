package sg.edu.nus.comp.cs3219r.templateView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import sg.edu.nus.comp.cs3219r.Utils;

/**
 * Markdown object, representing a particular markdown.
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class Markdown implements Template {
  
  // This object is thread safe!!
  private static HtmlRenderer renderer = HtmlRenderer.builder().build();
  
  private String value;

  public Markdown(String markdownFileName) throws IOException {
    
    String markdownContents = Utils.resourceToString(Utils.markdownBasePath, markdownFileName + Utils.markdownExtension);
    Parser parser = Parser.builder().build();
    Node document = parser.parse(markdownContents);
    this.value = renderer.render(document);
    
  }
  
  @Override
  public String key() {
    return "markdown";
  }

  @Override
  public String value() {
    return value;
  }

}
