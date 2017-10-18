package sg.edu.nus.comp.cs3219r.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UmlController extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String message;

  public void init() throws ServletException {
     // Do required initialization
     message = "UML";
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     
     // Set response content type
     response.setContentType("text/html");
     
     String req = "test";
     
     Uml uml = new Uml(req);
     UmlHtmlView umlView = new UmlHtmlView(uml);

     
     // Actual logic goes here.
     PrintWriter out = response.getWriter();
     out.println(umlView.generateHtml());
     
     
  }

  public void destroy() {
     // do nothing.
  }
}
