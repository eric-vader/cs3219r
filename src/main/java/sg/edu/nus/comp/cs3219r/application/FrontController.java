package sg.edu.nus.comp.cs3219r.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.edu.nus.comp.cs3219r.command.AppView;
import sg.edu.nus.comp.cs3219r.templateView.CmdDir;
import sg.edu.nus.comp.cs3219r.templateView.History;
import sg.edu.nus.comp.cs3219r.templateView.Markdown;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;
import sg.edu.nus.comp.cs3219r.templateView.Title;
import sg.edu.nus.comp.cs3219r.transform.HistoryTransformer;
import sg.edu.nus.comp.cs3219r.transform.CmdDirTransformer;

/**
 * Markdown Servlet.
 * @author Han Liang Wee, Eric
 *
 */
public class FrontController extends HttpServlet {
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     
     // Set response content type
     response.setContentType("text/html");

     // Actual logic goes here.
     PrintWriter out = response.getWriter();
     AppState state = new AppState("home", "Patterns Demo");
     AppView view = new AppView("tutorial", out);
     state.addObserver(view);
     state.notifyObservers();
  }

  public void destroy() {
     // do nothing.
  }
}