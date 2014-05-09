package de.inovex.academy.csd.legacy;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

public class TestFieldGenerator {

	@Test
	public void testGenerateField() {
		FieldGenerator gen = new FieldGenerator();
		Field<?> result = gen.generateField("myfield");
		assertThat(result, instanceOf(TextField.class));
	}

	@Test
	public void testGenerateFieldForCountry() {
		FieldGenerator gen = new FieldGenerator();
		Field<?> result = gen.generateField("Country");
		assertThat(result, instanceOf(ComboBox.class));
	}
	
	@Test
	public void testGenerateFieldForCountryValues() {
		FieldGenerator gen = new FieldGenerator();
		Field<?> result = gen.generateField("Country");
		assertThat(result, instanceOf(ComboBox.class));
		
		ComboBox comboBox = (ComboBox)result;
		Collection<?> ids = comboBox.getItemIds();
		
		assertThat(ids.size(), equalTo(2));
		assertThat(ids.contains("Germany"), equalTo(true));
		assertThat(ids.contains("USA"), equalTo(true));
	}

}
