package sg.edu.nus.comp.cs3219r.transform;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.command.LoginCommand;

@RegisterData(clazz={LoginCommand.class})
public class LoginCommandTransformer implements HtmlTransformer<Command> {

  private Command cmd;
  
  public LoginCommandTransformer(Command cmd) {
    this.cmd = cmd;
  }
  
  public LoginCommandTransformer(LoginCommand cmd) {
    this.cmd = cmd;
  }
  
  
  @Override
  public String openingTag() {
    //return "<li class='nav-item active'><a class='nav-link' href='#'>";
    return "<li class='nav-item dropdown'>\n" + 
        "    <a href='#' class='nav-link dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>Login</a>\n" + 
        "    <ul id='login-dp' class='dropdown-menu'>\n" + 
        "        <li>\n" +
        "            <form class='form' role='form' method='get' action='/' accept-charset='UTF-8' id='login-nav'>\n" + 
        "                <div class='form-group'>\n" +  
        "                    <input type='text' class='form-control' name='param' placeholder='Name ie. Carissa' required>\n" +
        "                    <input type='hidden' class='form-control' name='cmd' value='login' required>\n" +
        "                </div>\n" + 
        "                <div class='form-group'>\n" + 
        "                    <button type='submit' class='btn btn-primary btn-block'>Login</button>\n" + 
        "                </div>\n" + 
        "            </form>\n" + 
        "        </li>\n" + 
        "    </ul>\n" + 
        "</li>";
  }

  @Override
  public String closingTag() {
    return "";
    //return "</a></li>";
  }

  @Override
  public String data() {
    return "";
    //return this.cmd.getDisplayName();
  }

}
