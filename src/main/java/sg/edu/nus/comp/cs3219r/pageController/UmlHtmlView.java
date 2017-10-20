package sg.edu.nus.comp.cs3219r.pageController;

import java.io.IOException;

import sg.edu.nus.comp.cs3219r.templateView.Template;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;

public class UmlHtmlView {

  private Uml uml;
  private TemplateHelper umlHelper;

  public UmlHtmlView(Uml uml, String templateName) throws IOException {
    this.uml = uml;
    umlHelper = new TemplateHelper(templateName);
  }

  public String generateHtml() {

    this.umlHelper.register(this.uml);
    return this.umlHelper.render();

  }

}
