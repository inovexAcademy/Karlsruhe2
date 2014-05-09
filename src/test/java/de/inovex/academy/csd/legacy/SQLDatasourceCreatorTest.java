package de.inovex.academy.csd.legacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mockit.Cascading;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

@RunWith(JMockit.class)
public class SQLDatasourceCreatorTest {

	@Cascading
	Connection connection;
	@Cascading
	DriverManager driverManager;
	
	@Test
	public void testCreateSQLDatasource() throws SQLException {
		SQLDatasourceCreator creator = new SQLDatasourceCreator();
		
		new NonStrictExpectations() {
			{
				connection.prepareStatement("SELECT first_name, last_name, company, mobile_phone, work_phone, home_phone, work_email, home_email, street, city, zip, state, country FROM person");times = 1;
			}
		};
		
		creator.createSQLDatasource();
	}
	
	@Test(expected=Exception.class)
	public void testCreateSQLDatasourceWithException() throws SQLException {
		SQLDatasourceCreator creator = new SQLDatasourceCreator();
		
		new NonStrictExpectations() {
			{
				DriverManager.getConnection(anyString, anyString, anyString);times = 1; result = new Exception();
			}
		};
		
		IndexedContainer result = creator.createSQLDatasource();
		Item first = result.getItem(result.getItemIds().get(0));
		first.getItemProperty(AddressbookUI.FNAME);
	}

}
