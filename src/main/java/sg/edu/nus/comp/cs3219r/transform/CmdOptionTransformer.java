package sg.edu.nus.comp.cs3219r.transform;

import java.util.List;

import sg.edu.nus.comp.cs3219r.templateView.CmdDir;
import sg.edu.nus.comp.cs3219r.templateView.Template;

@RegisterData(clazz = CmdOption.class)
public class CmdOptionTransformer implements HtmlTransformer<CmdOption> {
  
  private CmdOption cmdOption;
  
  public CmdOptionTransformer(CmdOption cmdOption) {
    this.cmdOption = cmdOption;
  }
  
  @Override
  public String openingTag() {
    return String.format("<a class='dropdown-item' href='?cmd=%s&%s=%s'>", 
    		cmdOption.getCmdId(), 
    		cmdOption.getParam(),
    		cmdOption.getVal());
  }

  @Override
  public String closingTag() {
    return "</a>";
  }

  @Override
  public String data() {
    return cmdOption.getDisplay();
  }

}
