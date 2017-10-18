package sg.edu.nus.comp.cs3219r;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sg.edu.nus.comp.cs3219r.diagram.Diagram;
import sg.edu.nus.comp.cs3219r.diagram.Link;
import sg.edu.nus.comp.cs3219r.diagram.Method;
import sg.edu.nus.comp.cs3219r.diagram.Node;
import sg.edu.nus.comp.cs3219r.diagram.Parameter;
import sg.edu.nus.comp.cs3219r.diagram.Property;
import sg.edu.nus.comp.cs3219r.diagram.Relationship;
import sg.edu.nus.comp.cs3219r.diagram.Visibility;

/**
 * Generates Uml Diagram for go.js to be used on the web.
 *
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class GenerateUmlApp {

  

  public static void main(String[] args) throws IOException {
    
    String outputDir = Utils.getAbsResourcePath(Utils.umlBasePath);
    
    Gson gson_p = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();
    
    // Generate the diagram
    Diagram d = new Diagram(Arrays.asList(new Class[] {Diagram.class,
        Link.class, Method.class, Node.class, Parameter.class, Property.class,
        Relationship.class, Visibility.class}));


    Path path = Paths.get(outputDir + "/test.json");
    byte[] strToBytes = gson.toJson(d).getBytes();
    Files.write(path, strToBytes);

    System.out.println(gson_p.toJson(d));
    
  }
}
