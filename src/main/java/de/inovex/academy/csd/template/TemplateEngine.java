package de.inovex.academy.csd.template;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {

	private String template;
	private static Pattern pattern = Pattern.compile("\\$\\{\\w+\\}");
	
	public TemplateEngine(String template) {
		this.template = template;
	}

	public String render(Map<String, String> parameter) {
		String result = template;
		for (String key : parameter.keySet()) {
			if (result.indexOf("${" + key + "}") != -1) {
				result = result.replace("${" + key + "}", parameter.get(key));
			} else {
				throw new ParameterNotFoundException();
			}
		}
		Matcher matcher = pattern.matcher(result);
		if (matcher.find()) {
			throw new PlaceholderNotFoundException();
		}
		return result;
	}

}
