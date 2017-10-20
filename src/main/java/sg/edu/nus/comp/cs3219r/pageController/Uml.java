package sg.edu.nus.comp.cs3219r.pageController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import sg.edu.nus.comp.cs3219r.Utils;
import sg.edu.nus.comp.cs3219r.templateView.Template;

/**
 * Reads the UML json file from disk.
 * @author Han Liang Wee, Eric
 *
 */
public class Uml extends Template {

  private String json;
  
  public Uml(String jsonFileName) throws IOException {
    
    json = Utils.resourceToString(Utils.umlBasePath, jsonFileName + Utils.umlExtension);
    
  }

  @Override
  public String key() {
    return "uml";
  }

  @Override
  public String value() {
    return json;
  }
  
}
