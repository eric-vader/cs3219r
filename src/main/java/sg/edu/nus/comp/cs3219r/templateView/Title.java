package sg.edu.nus.comp.cs3219r.templateView;

public class Title implements Template {

  private String appName;
  private String pageName;

  public Title(String appName) {
    this.appName = appName;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public String getPageName() {
    return pageName;
  }

  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  @Override
  public String key() {
    return "title";
  }

  @Override
  public String value() {
    if (this.pageName == null) {
      return this.appName;
    } else {
      return this.appName + " - " + this.pageName;
    }
  }


}
