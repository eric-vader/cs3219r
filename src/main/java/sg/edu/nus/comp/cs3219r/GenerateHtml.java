package sg.edu.nus.comp.cs3219r;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.comp.cs3219r.pageController.Uml;
import sg.edu.nus.comp.cs3219r.pageController.UmlHtmlView;
import sg.edu.nus.comp.cs3219r.templateView.CmdDir;
import sg.edu.nus.comp.cs3219r.templateView.History;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;
import sg.edu.nus.comp.cs3219r.transform.CmdDirTransformer;
import sg.edu.nus.comp.cs3219r.transform.HtmlTransformer;
import sg.edu.nus.comp.cs3219r.transform.RegisterData;


public class GenerateHtml {


  public static void main(String[] args) throws IOException {

//    Utils.init();
//    
//    TemplateHelper helper = new TemplateHelper("tutorial");
//    helper.register(new CmdDir());
//    System.out.println(helper.render());

    // Collections.sort(registrations,
    // Comparator.<RunAtStartupData>comparingInt(x -> x.priority).reversed());
    //
    // for (RunAtStartupData registration : registrations) {
    // registration.callMethod();
    // }
  }
}
