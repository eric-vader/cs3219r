package sg.edu.nus.comp.cs3219r.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import sg.edu.nus.comp.cs3219r.templateView.CmdDir;
import sg.edu.nus.comp.cs3219r.templateView.History;
import sg.edu.nus.comp.cs3219r.templateView.Markdown;
import sg.edu.nus.comp.cs3219r.templateView.Template;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;
import sg.edu.nus.comp.cs3219r.templateView.Title;

/**
 * State of the application
 * @author 
 *
 */
public class AppState extends Observable {
  
  private CmdDir cmdDir;
  private History history;
  private Markdown markdown;
  private Title title;

  public AppState(String homeMd, String appName) throws IOException {
    this.cmdDir = new CmdDir(appName);
    this.history = new History();
    this.markdown = new Markdown(homeMd);
    this.title = new Title(appName);
    this.setChanged();
  }

  public CmdDir getCmdDir() {
    return cmdDir;
  }

  public History getHistory() {
    return history;
  }

  public Markdown getMarkdown() {
    return markdown;
  }

  public Title getTitle() {
    return title;
  }
  
}
