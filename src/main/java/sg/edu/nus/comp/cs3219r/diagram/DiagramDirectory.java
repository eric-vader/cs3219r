package sg.edu.nus.comp.cs3219r.diagram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import sg.edu.nus.comp.cs3219r.Utils;
import sg.edu.nus.comp.cs3219r.pageController.Uml;
import sg.edu.nus.comp.cs3219r.pageController.UmlController;
import sg.edu.nus.comp.cs3219r.pageController.UmlHtmlView;

public class DiagramDirectory {

  private Map<String, Diagram> lookup;
  private String outputDir;

  public static List<String> getKeys() {
    List<String> l = new ArrayList<String>();
    l.add("uml");
    l.add("pageController");
    return l;
  }

  public static List<Diagram> getDiagrams() {
    List<Diagram> l = new ArrayList<>();
    l.add(new Diagram(Arrays.asList(new Class[] {Diagram.class, Link.class,
        Method.class, Node.class, Parameter.class, Property.class,
        Relationship.class, Visibility.class})));
    l.add(new Diagram(Arrays.asList(
        new Class[] {Uml.class, UmlController.class, UmlHtmlView.class})));
    return l;
  }

  public DiagramDirectory() {

    lookup = new HashMap<String, Diagram>();
    outputDir = Utils.getAbsResourcePath(Utils.umlBasePath);

    List<String> keys = getKeys();
    List<Diagram> diagrams = getDiagrams();

    for (int i = 0; i < keys.size(); i++) {
      lookup.put(keys.get(i), diagrams.get(i));
    }

  }

  public void writeToDisk(Gson gson) throws IOException {
    for (String eaKey : lookup.keySet()) {
      Path path = Paths.get(outputDir + "/" + eaKey + ".json");
      byte[] strToBytes = gson.toJson(lookup.get(eaKey)).getBytes();
      Files.write(path, strToBytes);
    }
  }

}
