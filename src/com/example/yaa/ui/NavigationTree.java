package com.example.yaa.ui;

import com.example.yaa.YaaApplication;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;

public class NavigationTree extends Tree 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Object SHOW_ALL = "Show all";
	public static final Object SEARCH = "Search";
	
	public  NavigationTree(YaaApplication app)
	{
		addItem(SHOW_ALL);
		addItem(SEARCH);	
		addListener((ItemClickListener) app);
	}

}
