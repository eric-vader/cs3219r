package sg.edu.nus.comp.cs3219r;

import java.io.IOException;

import sg.edu.nus.comp.cs3219r.page.Uml;
import sg.edu.nus.comp.cs3219r.page.UmlHtmlView;


public class GenerateUmlHtml {
  public static void main(String[] args) throws IOException {
    
    String req = "test";
    
    Uml uml = new Uml(req);
    UmlHtmlView umlView = new UmlHtmlView(uml);
    System.out.println(umlView.generateHtml());
  }
}
