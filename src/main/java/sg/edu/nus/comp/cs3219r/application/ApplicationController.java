package sg.edu.nus.comp.cs3219r.application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import sg.edu.nus.comp.cs3219r.command.Command;

/**
 * This is also the Originator in the momento pattern. 
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class ApplicationController {

	private AppState state; 
	private AppView view;
	
	public ApplicationController() throws IOException {
		this.state = new AppState("home", "Patterns Demo");
		this.view = new AppView("tutorial");
		this.state.addObserver(this.view);
		this.state.notifyObservers();
	}
	
	public void printView(PrintWriter out) {
		this.state.notifyObservers();
		out.print(this.view.getHtmlPage());
	}

	/**
	 * Retrieves the domain command.
	 * 
	 * @param request Request parameters
	 */
	public Command getDomainCommand(HttpServletRequest request) {
		return this.state.getCmdDir().get(request.getParameter("cmd"));
	}

	/**
	 * Runs the command.
	 * @param cmd
	 */
	public void run(Command cmd, HttpServletRequest request) {
		cmd.execute_webapp(this.state, request);
	}
	
	public AppState createMomento() {
		return state;
	}
	
	public void restore(AppState state) {
		
	}
	
}
