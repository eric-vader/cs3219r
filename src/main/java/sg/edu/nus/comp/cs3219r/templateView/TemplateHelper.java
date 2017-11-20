package sg.edu.nus.comp.cs3219r.templateView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.regex.Matcher;

import sg.edu.nus.comp.cs3219r.Utils;

/**
 * Part of the template class, to translate the
 * 
 * @author Han Liang Wee, Eric(A0065517A)
 *
 */
public class TemplateHelper {

	private HashMap<String, Template> templates;
	private String htmlFile;

	public TemplateHelper(String fileName) throws IOException {
		this.templates = new HashMap<>();
		htmlFile = Utils.resourceToString(Utils.templatesBasePath, fileName + Utils.templateExtension);
	}

	/**
	 * Registers template objects into this helper.
	 * 
	 * @param template
	 *            Template to
	 */
	public void register(Template template) {
		this.templates.put(template.key(), template);
	}

	public String render() {
		String replacedHtml = htmlFile;
		for (Template eaTemplate : templates.values()) {
			replacedHtml = replacedHtml.replaceAll("\\{\\{" + eaTemplate.key() + "\\}\\}",
					Matcher.quoteReplacement(eaTemplate.value()));
		}
		return replacedHtml;
	}

	public void reset() {
		templates.clear();
	}

}
