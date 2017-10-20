package sg.edu.nus.comp.cs3219r.transform;

import java.util.List;

import sg.edu.nus.comp.cs3219r.templateView.CmdDir;
import sg.edu.nus.comp.cs3219r.templateView.Template;

@RegisterData(clazz = CmdDir.class)
public class CmdDirTransformer implements HtmlTransformer<CmdDir> {
  
  private CmdDir cmdDir;
  
  public CmdDirTransformer(CmdDir cmdDir) {
    this.cmdDir = cmdDir;
  }
  
  @Override
  public String openingTag() {
    return "<nav class='navbar navbar-expand-md navbar-dark fixed-top bg-dark'>" +
            "<a class='navbar-brand' href='#'>" + this.cmdDir.getDirName() + "</a>" + 
            "<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarCollapse' aria-controls='navbarCollapse' aria-expanded='false' aria-label='Toggle navigation'>\n" + 
            "<span class='navbar-toggler-icon'></span>\n" + 
            "</button>\n" + 
            "<div class='collapse navbar-collapse' id='navbarCollapse'>\n" + 
            "<ul class='navbar-nav mr-auto'>\n"
        ;
  }

  @Override
  public String closingTag() {
    return "</ul></div></nav>";
  }

  @Override
  public String data() {
    return HtmlTransformer.flattenChildren(cmdDir.getCommands());
  }

}
