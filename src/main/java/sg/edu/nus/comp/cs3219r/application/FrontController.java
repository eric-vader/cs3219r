package sg.edu.nus.comp.cs3219r.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.edu.nus.comp.cs3219r.command.Command;
import sg.edu.nus.comp.cs3219r.templateView.CmdDir;
import sg.edu.nus.comp.cs3219r.templateView.History;
import sg.edu.nus.comp.cs3219r.templateView.Markdown;
import sg.edu.nus.comp.cs3219r.templateView.TemplateHelper;
import sg.edu.nus.comp.cs3219r.templateView.Title;
import sg.edu.nus.comp.cs3219r.transform.HistoryTransformer;
import sg.edu.nus.comp.cs3219r.transform.CmdDirTransformer;

/**
 * Markdown Servlet.
 * 
 * @author Han Liang Wee, Eric
 *
 */
public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static ApplicationController appController = null;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			appController = new ApplicationController();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();

		Command cmd = appController.getDomainCommand(request);
		if (cmd != null)
			appController.run(cmd, request);

		// Finally print output to user
		appController.printView(out);

		// Standard return headers
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

	}

}