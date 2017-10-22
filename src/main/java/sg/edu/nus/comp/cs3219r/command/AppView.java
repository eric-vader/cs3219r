package sg.edu.nus.comp.cs3219r.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import sg.edu.nus.comp.cs3219r.application.AppState;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;

public class AppView implements Observer {

  private TemplateHelper helper;
  private String htmlPage;
  private PrintWriter out;

  public AppView(String baseTemplate, PrintWriter out) throws IOException {
    helper = new TemplateHelper(baseTemplate);
    this.out = out;
  }

  @Override
  public void update(Observable o, Object arg) {

    AppState state = (AppState) o;

    helper.reset();
    helper.register(state.getCmdDir());
    helper.register(state.getHistory());
    helper.register(state.getMarkdown());
    helper.register(state.getTitle());
    this.htmlPage = helper.render();
    out.print(htmlPage);
  }

}
