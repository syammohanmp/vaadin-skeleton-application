package com.example.yaa.ui;

import com.vaadin.ui.TextField;
import com.vaadin.ui.Button;

import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;

public class PersonForm extends Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button save =  new Button("Save");
	private Button cancel =  new Button("Cancel");
	
	public PersonForm()
	{
		addField("First Name",   new TextField("First Name"));
		addField("Last Name",   new TextField("Last Name"));
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		setFooter(footer);
	}
}
