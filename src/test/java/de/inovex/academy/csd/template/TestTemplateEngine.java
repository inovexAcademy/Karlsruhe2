package de.inovex.academy.csd.template;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestTemplateEngine {

	@Test
	public void testRender() {
		TemplateEngine templateEngine = new TemplateEngine("Hallo");
		assertThat(templateEngine.render(new HashMap<String, String>()), is("Hallo"));

		TemplateEngine templateEngine2 = new TemplateEngine("Hallo ${name}");
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("name", "Daniel");
		assertThat(templateEngine2.render(parameter), is("Hallo Daniel"));
		
		TemplateEngine templateEngine3 = new TemplateEngine("Hallo ${name} and ${name2}");
		Map<String, String> parameter3 = new HashMap<String, String>();
		parameter3.put("name", "Daniel");
		parameter3.put("name2", "Markus");
		assertThat(templateEngine3.render(parameter3), is("Hallo Daniel and Markus"));
		
	}
	
	@Test
	public void testRenderDoublePlaceholders() {
		TemplateEngine templateEngine = new TemplateEngine("Hallo ${name}. Wie geht's Dir, ${name}?");
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("name", "Daniel");
		assertThat(templateEngine.render(parameter), is("Hallo Daniel. Wie geht's Dir, Daniel?"));
	}
	
	@Test(expected=ParameterNotFoundException.class)
	public void testRenderNotFoundParameter() {
		TemplateEngine templateEngine = new TemplateEngine("Hallo ${name}. Wie geht's Dir, ${name}?");
		Map<String, String> parameter = new HashMap<String, String>();
		parameter.put("name", "Daniel");
		parameter.put("zustand", "schlecht");
		templateEngine.render(parameter);
	}
}
