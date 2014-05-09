package de.inovex.academy.csd.legacy;

import com.vaadin.data.Item;
import com.vaadin.data.Container.Filter;

/*
 * A custom filter for searching names and companies in the
 * contactContainer.
 */
class ContactFilter implements Filter {
	private String needle;
	
	private String[] fieldNames = new String[] { AddressbookUI.FNAME, AddressbookUI.LNAME,
		AddressbookUI.COMPANY};

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}

	public ContactFilter(String needle) {
		this.needle = needle.toLowerCase();
	}

	public boolean passesFilter(Object itemId, Item item) {
		String haystack = "";
		for (String name : fieldNames) {
			haystack = haystack + item.getItemProperty(name).getValue();
		}
		return haystack.toLowerCase().contains(needle);
	}

	public boolean appliesToProperty(Object id) {
		return true;
	}
}