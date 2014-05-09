package de.inovex.academy.csd.legacy;

import static org.junit.Assert.fail;
import mockit.Cascading;
import mockit.NonStrictExpectations;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.vaadin.data.Item;

@RunWith(JMockit.class)
public class ContactFilterTest {

	@Cascading
	Item item;

	@Test
	public void testPassesFilter() {
		ContactFilter filter = new ContactFilter("myneedle");
		new NonStrictExpectations() {
			{
				item.getItemProperty(anyString);times = 3;
				item.getItemProperty(AddressbookUI.FNAME);times = 1;
				item.getItemProperty(AddressbookUI.LNAME);times = 1;
				item.getItemProperty(AddressbookUI.COMPANY);times = 1;
			}
		};
		filter.passesFilter(null, item);
		
	}
	
	@Test
	public void testPassesFilterForAllAttributes() {
		final String[] fieldNames = new String[] { "First Name", "Last Name",
				"Company", "Mobile Phone", "Work Phone", "Home Phone", "Work Email",
				"Home Email", "Street", "City", "Zip", "State", "Country" };
		ContactFilter filter = new ContactFilter("myneedle2");
		filter.setFieldNames(fieldNames);
		new NonStrictExpectations() {
			{
				for (String name : fieldNames) {
					item.getItemProperty(name);times = 1;
				}
//				item.getItemProperty(anyString);times = fieldNames.length;
			}
		};
		filter.passesFilter(null, item);
		
	}

	@Test
	public void testAppliesToProperty() {
		
	}

}
