package org.scrum1.sese.view.page;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.scrum1.sese.view.page.panels.NavigationPanel;

public class BasePage extends WebPage{

	private static final long serialVersionUID = 4340442722408654508L;

	public BasePage() {
		this(null);
	}

	public BasePage(IModel<?> model) {
		super(model);
		this.add(new NavigationPanel("mainNav"));
	}


}
