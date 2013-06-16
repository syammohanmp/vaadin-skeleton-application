package com.example.yaa.ui;

import com.example.yaa.YaaApplication;
import com.example.yaa.data.PersonContainer;
import com.vaadin.data.Property;
import com.vaadin.ui.Table;

public class PersonList extends Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonList(YaaApplication app) {
		// create some dummy data
		/*addContainerProperty("First Name", String.class, "Syam");
		addContainerProperty("Last Name", String.class, "Vilakudy");
		addContainerProperty("Email", String.class, "Syamvilakudy@hgmail.com");
		addItem();*/
		
 
		setSizeFull();
		setSelectable(true);
		setImmediate(true);
		addListener((Property.ValueChangeListener) app);
		/* We don't want to allow users to de-select a row */
		setNullSelectionAllowed(false);
		setContainerDataSource(app.getDataSource());
		setVisibleColumns(PersonContainer.NATURAL_COL_ORDER);
		setColumnHeaders(PersonContainer.COL_HEADERS_ENGLISH);
		}
}
