package org.scrum1.sese.view.page.panels;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.view.page.LoginPage;
import org.scrum1.sese.view.page.MainPage;
import org.scrum1.sese.view.page.RegisterPage;
import org.scrum1.sese.view.page.ReservationListPage;
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
		
		Link reservationListLink = new Link<String>("list_reservations") {
			@Override
			public void onClick() {
				this.setResponsePage(new ReservationListPage());
			}
		};
		this.add(reservationListLink);
		
		Link loginLink = new Link<String>("login") {
			@Override
			public void onClick() {
				CustomerImpl customer = new CustomerImpl();
				this.setResponsePage(new LoginPage(customer));
			}
		};
		this.add(loginLink);
		
		Link registerLink = new Link<String>("register") {
			@Override
			public void onClick() {
				CustomerImpl customer = new CustomerImpl();
				this.setResponsePage(new RegisterPage(customer));
			}
		};
		this.add(registerLink);
	}
	
}
