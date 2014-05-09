package de.inovex.academy.csd.legacy;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;
import com.vaadin.ui.TextField;

class FieldGenerator {
	public Field<?> generateField(String fieldname) {

		if ("Country".equals(fieldname)) {
			ComboBox comboBox = new ComboBox(fieldname);
			comboBox.addItem("Germany");
			comboBox.addItem("USA");
			return comboBox;
		}
		return new TextField(fieldname);
	}
}