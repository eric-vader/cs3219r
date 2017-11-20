package sg.edu.nus.comp.cs3219r.pageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.edu.nus.comp.cs3219r.AppDesignPlane;
import sg.edu.nus.comp.cs3219r.Utils;
import sg.edu.nus.comp.cs3219r.application.AppView;
import sg.edu.nus.comp.cs3219r.diagram.DiagramDirectory;

public class UmlController extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
     
     // Set response content type
     response.setContentType("text/html");
     
     String htmlOut = "";
     Set<String> allowedIds = new HashSet<>();
     for(AppDesignPlane eaAppPlane:Utils.listAppPlanes()) {
       allowedIds.add(eaAppPlane.getId());
     }
     if(request.getPathInfo()!=null && allowedIds.contains(request.getPathInfo().substring(1))) {
       Uml uml = new Uml(request.getPathInfo().substring(1));
       UmlHtmlView umlView = new UmlHtmlView(uml, "uml");
       htmlOut = umlView.generateHtml();
     }
     
     // Actual logic goes here.
     PrintWriter out = response.getWriter();
     out.println(htmlOut);
     
  }

  public void destroy() {
     // do nothing.
  }
}
