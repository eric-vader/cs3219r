package sg.edu.nus.comp.cs3219r.template;

/**
 * A simple Template class with a key and a value. The template helper will
 * track based on the key specified in the file.
 *
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public abstract class Template {

  private String fileContents;
  
  abstract String key();

  abstract String value();

  public String getFileContents() {
    return fileContents;
  }

  public void setFileContents(String fileContents) {
    this.fileContents = fileContents;
  }
  
}
