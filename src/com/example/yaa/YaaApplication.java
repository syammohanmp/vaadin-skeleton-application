package com.example.yaa;

 

import com.example.yaa.data.PersonContainer;



import com.example.yaa.ui.ListView;
import com.example.yaa.ui.NavigationTree;
import com.example.yaa.ui.PersonForm;
import com.example.yaa.ui.PersonList;
import com.example.yaa.ui.SearchView; 
import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
 
 
public class YaaApplication extends Application implements Button.ClickListener,
                                                           com.vaadin.data.Property.ValueChangeListener,
                                                           ItemClickListener 
                                                           
                                                           {
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button newContact = new Button("Add contact");
	private Button search = new Button("Search");
	private Button share = new Button("Share");
	private Button help = new Button("Help");
	private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
	private NavigationTree  tree = null;
 
	private ListView listView = null;
	private SearchView searchView = null;
	private PersonContainer dataSource = PersonContainer.createWithTestData();
	private PersonList personList = null;
	private PersonForm personForm = null;
	
	public void init() {
		/*Window mainWindow = new Window("Yaa Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);*/ 
		buildMainLayout();
		
	}
	
	@SuppressWarnings("deprecation")
	private void buildMainLayout() {
		setTheme("contacts");
		setMainWindow(new Window("Ya my demo"));
		VerticalLayout layout = new VerticalLayout();
		layout.setStyleName("yii");
		layout.setSizeFull();
		layout.addComponent(createToolbar());
		horizontalSplit.setFirstComponent(getNavigationTree());
		
		listView =  getListView();
		setMainComponent(listView); 
		layout.addComponent(horizontalSplit);
		/* Allocate all available extra space to the horizontal split panel */
		layout.setExpandRatio(horizontalSplit, 1);
		/* Set the initial split position so we can have a 200 pixel menu to
		the left */
		horizontalSplit.setSplitPosition(200, SplitPanel.UNITS_PIXELS);
		getMainWindow().setContent(layout);
		}
	
	public HorizontalLayout createToolbar() 
	{
		HorizontalLayout lo = new HorizontalLayout();
        lo.addComponent(newContact);
        lo.addComponent(search);
        lo.addComponent(share);
        lo.addComponent(help);

        search.addListener((ClickListener) this);
        share.addListener((ClickListener) this);
        help.addListener((ClickListener) this);
        newContact.addListener((ClickListener) this);

        search.setIcon(new ThemeResource("icons/32/folder-add.png"));
        share.setIcon(new ThemeResource("icons/32/users.png"));
        help.setIcon(new ThemeResource("icons/32/help.png"));
        newContact.setIcon(new ThemeResource("icons/32/document-add.png"));
        
        

        lo.setMargin(true);
        lo.setSpacing(true);
        lo.setStyleName("toolbar");
        lo.setWidth("100%");

        Embedded em = new Embedded("", new ThemeResource("images/logo.png"));
        lo.addComponent(em);
        lo.setComponentAlignment(em, Alignment.MIDDLE_RIGHT);
        lo.setExpandRatio(em, 1);

        return lo;
		
		}
	
	   private void setMainComponent(Component c)
	   {
		horizontalSplit.setSecondComponent(c);
		}
	    
	   public PersonContainer getDataSource()
	   {
		   return dataSource;
	   }
	   
	   private NavigationTree getNavigationTree()
	   {
	     if(tree == null)
	     {
	       tree = new NavigationTree(this);
	     }
	     return tree;
	   }
	   private ListView getListView() {
		   if (listView == null) {
		   personList = new PersonList(this);
		   personForm = new PersonForm();
		   listView = new ListView(personList, personForm);
		   }
		   return listView;
		 }
	   
	  private void showListView()
	  {
		  setMainComponent(getListView());
	  }
	  
	   private SearchView getSearchview()
	   {
		   if(searchView == null)
		   {
			   searchView = new SearchView(this);
		   }
		   return searchView;
	   
	   }
	   
	   private void showSearchView()
	   {
		   setMainComponent(getSearchview());
	   }

	    public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
	    	final Button source = event.getButton();
	    	if (source == search) {
	    	showSearchView();
	    	 
	    	}
	    }

		public void valueChange(ValueChangeEvent event) {
			// TODO Auto-generated method stub
			Property property = event.getProperty();
			if (property == personList) {
				Item item = personList.getItem(personList.getValue());
				if (item != personForm.getItemDataSource()) {
				personForm.setItemDataSource(item);
				}
			}
		}

		public void itemClick(ItemClickEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == tree) {
				Object itemId = event.getItemId();
				if (itemId != null) {
				if (NavigationTree.SHOW_ALL.equals(itemId)) {
				showListView();
				} else if (NavigationTree.SEARCH.equals(itemId)) {
				showSearchView();
				}
				}
				}
			
		}
	   
	   
	    
}
