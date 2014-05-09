package de.inovex.academy.csd.legacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vaadin.data.util.IndexedContainer;

public class SQLDatasourceCreator {
	public IndexedContainer createSQLDatasource() {
		IndexedContainer ic = new IndexedContainer();

		for (String p : AddressbookUI.fieldNames) {
			ic.addContainerProperty(p, String.class, "");
		}

		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:hsqldb:file:db/persons", "SA", "");
			PreparedStatement stmt = conn
					.prepareStatement("SELECT first_name, last_name, company, mobile_phone, work_phone, home_phone, work_email, home_email, street, city, zip, state, country FROM person");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Object id = ic.addItem();
				for (String fieldName : AddressbookUI.fieldNames) {
					String value = rs.getString(fieldName.replaceAll(" ", "_")
							.toLowerCase());
					if (value != null) {
						ic.getContainerProperty(id, fieldName).setValue(value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ic;
	}
}