package de.inovex.academy.csd.template;

import java.util.Map;

public class TemplateEngine {

	private String template;
	
	public TemplateEngine(String template) {
		this.template = template;
	}

	public String render(Map<String, String> parameter) {
		String result = template;
		for (String key : parameter.keySet()) {
			if (result.indexOf("${" + key + "}") != -1) {
				result = result.replace("${" + key + "}", parameter.get(key));
			}
		}
		return result;
	}

}
