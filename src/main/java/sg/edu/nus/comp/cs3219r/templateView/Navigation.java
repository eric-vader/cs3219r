package sg.edu.nus.comp.cs3219r.templateView;

import java.util.List;

import sg.edu.nus.comp.cs3219r.transform.TransformableHtmlData;

public class Navigation extends Template implements TransformableHtmlData {

  @Override
  public String key() {
    return "nav";
  }

  @Override
  public String value() {
    return 
        "<nav class='navbar navbar-expand-md navbar-dark fixed-top bg-dark'>\n" + 
        "<a class='navbar-brand' href='#'>CS3219R</a>\n" + 
        "<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarCollapse' aria-controls='navbarCollapse' aria-expanded='false' aria-label='Toggle navigation'>\n" + 
        "<span class='navbar-toggler-icon'></span>\n" + 
        "</button>\n" + 
        "<div class='collapse navbar-collapse' id='navbarCollapse'>\n" + 
        "<ul class='navbar-nav mr-auto'>\n" + 
        "<li class='nav-item active'>\n" + 
        "<a class='nav-link' href='#'>Home <span class='sr-only'>(current)</span></a>\n" + 
        "</li>\n" + 
        "<li class='nav-item'>\n" + 
        "<a class='nav-link' href='#'>Link</a>\n" + 
        "</li>\n" + 
        "<li class='nav-item'>\n" + 
        "<a class='nav-link disabled' href='#'>Disabled</a>\n" + 
        "</li>\n" + 
        "</ul>\n" + 
        "</div>\n" + 
        "</nav>";
  }

  @Override
  public String openingTag() {
    return "<nav class='navbar navbar-expand-md navbar-dark fixed-top bg-dark'>";
  }

  @Override
  public String closingTag() {
    return "</nav>";
  }

  @Override
  public String data() {
    // TODO Auto-generated method stub
    return null;
  }

}
