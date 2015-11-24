package org.scrum1.sese.view.page;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.scrum1.sese.view.page.panels.NavigationPanel;

public class BasePage extends WebPage{

	public BasePage() {
		this(null);
	}
	
	BasePage(IModel model) {
		super(model);
		this.add(new NavigationPanel("mainNav"));
		
		
		Date now = new Date();
		this.add(new Label("datetime", now.toString()));
	}
	
	
}
