package sg.edu.nus.comp.cs3219r;

import java.io.IOException;

import sg.edu.nus.comp.cs3219r.pageController.Uml;
import sg.edu.nus.comp.cs3219r.pageController.UmlHtmlView;
import sg.edu.nus.comp.cs3219r.templateView.Navigation;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;


public class GenerateHtml {
  public static void main(String[] args) throws IOException {
    
    TemplateHelper helper = new TemplateHelper("tutorial");
    helper.register(new Navigation());
    System.out.println(helper.render());
  }
}
