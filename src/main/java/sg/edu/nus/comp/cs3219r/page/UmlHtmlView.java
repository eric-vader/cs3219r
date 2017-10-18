package sg.edu.nus.comp.cs3219r.page;

import sg.edu.nus.comp.cs3219r.template.TemplateHelper;

import java.io.IOException;

import sg.edu.nus.comp.cs3219r.template.Template;

public class UmlHtmlView {

  private Uml uml;
  private TemplateHelper umlHelper;

  public UmlHtmlView(Uml uml) throws IOException {
    this.uml = uml;
    umlHelper = new TemplateHelper("uml");
  }
  
  public String generateHtml() {
    
    this.umlHelper.register(this.uml);
    return this.umlHelper.render();
    
  }
  
}
