package sg.edu.nus.comp.cs3219r.templateView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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
  
  private Map<String, String> markdowns;
  private Map<String, Integer> indexLooup;
  private String[] markdownIds;
  private int index;
  private int numMarkdowns;
  private String value;

  public Markdown(String... markdownFileNames) throws IOException {
	  markdowns = new HashMap<String, String>();
	  indexLooup = new HashMap<>();
	  String home = markdownFileNames[0];
	  for(String markdownFileName : markdownFileNames) {
		  loadMarkdown(markdownFileName);
	  }
	  this.value = markdowns.get(home);
	  this.index = indexLooup.get(home);
	  this.markdownIds = markdownFileNames;
  }
  
  public void loadMarkdown(String markdownFileName) throws IOException {
	    String markdownContents = Utils.resourceToString(Utils.markdownBasePath, markdownFileName + Utils.markdownExtension);
	    Parser parser = Parser.builder().build();
	    Node document = parser.parse(markdownContents);
	    markdowns.put(markdownFileName, renderer.render(document));
	    indexLooup.put(markdownFileName, numMarkdowns);
	    numMarkdowns++;
  }
  
  public void update(String markdownId) {
	  this.value = markdowns.get(markdownId);
	  this.index = indexLooup.get(markdownId);
  }
  
  public boolean is_next() {
	  return index < numMarkdowns-1;
  }
  
  public boolean is_prev() {
	  return index > 0;
  }
  
  public boolean next_page() {
	  index++;
	  this.value = markdowns.get(this.markdownIds[index]);
	  return is_next();
  }
  
  public boolean prev_page() {
	  index--;
	  this.value = markdowns.get(this.markdownIds[index]);
	  return is_prev();
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
