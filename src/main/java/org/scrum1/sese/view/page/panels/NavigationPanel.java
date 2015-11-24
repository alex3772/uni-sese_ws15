package org.scrum1.sese.view.page.panels;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.scrum1.sese.view.page.MainPage;
import org.scrum1.sese.view.page.RoomListPage;

public class NavigationPanel extends Panel{

	public NavigationPanel(String id) {
		super(id);
		
		/* Add navigation links to panel */
		
		Link homeLink = new Link<String>("home") {
			@Override
			public void onClick() {
				this.setResponsePage(new MainPage());
			}
		};
		this.add(homeLink);
		Link roomsListLink = new Link<String>("list_rooms") {
			@Override
			public void onClick() {
				this.setResponsePage(new RoomListPage());
			}
		};
		this.add(roomsListLink);
	}
	
}
