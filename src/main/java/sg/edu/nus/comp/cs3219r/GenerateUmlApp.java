package sg.edu.nus.comp.cs3219r;

import java.io.IOException;

import com.google.gson.Gson;

import sg.edu.nus.comp.cs3219r.diagram.DiagramDirectory;

/**
 * Generates Uml Diagram for go.js to be used on the web.
 *
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class GenerateUmlApp {

  public static void main(String[] args) throws IOException {
    
    DiagramDirectory dir = new DiagramDirectory();
    dir.writeToDisk(new Gson());

  }
}