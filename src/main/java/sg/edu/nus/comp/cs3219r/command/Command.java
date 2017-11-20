package sg.edu.nus.comp.cs3219r.command;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import sg.edu.nus.comp.cs3219r.application.AppState;
import sg.edu.nus.comp.cs3219r.templateView.CmdOption;

public abstract class Command {

	private final String displayName;
	private final String id;
	private final List<String> avaliableParameters;
	private List<CmdOption> avaliableOptions;
	private boolean isHidden;

	protected void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public Command(String displayName, String id, String... avaliableParameters) {
		this.displayName = displayName;
		this.id = id;
		this.avaliableParameters = Arrays.asList(avaliableParameters);
		this.avaliableOptions = new ArrayList<>();
		this.isHidden = false;
	}

	public String getDisplayName() {
		return displayName;
	}

	public List<String> getAvaliableParameters() {
		return avaliableParameters;
	}
	
	protected void addOption(String display, String param, String value) {
		CmdOption option = new CmdOption();
		option.setCmdId(this.id);
		option.setParam(param);
		option.setVal(value);
		option.setDisplay(display);
		this.avaliableOptions.add(option);
	}
	
	public List<CmdOption> getOptions() {
		return this.avaliableOptions;
	}

	/**
	 * Convenient function to execute requests from servlets, it extracts the
	 * parameters directly and invokes execute. It will also store the history
	 * and the app state to the appropriate objects.
	 */
	public void execute_webapp(AppState state, HttpServletRequest request) {
		List<String> parameters = new ArrayList<>();
		for(String eaParam : this.avaliableParameters) {
			parameters.add(request.getParameter(eaParam));
		}
		this.execute(state, parameters.toArray(new String[parameters.size()]));
	}

	public abstract void execute(AppState state, String... parameters);

	public boolean isHidden() {
		return isHidden;
	}

	public String getId() {
		return id;
	}
}
