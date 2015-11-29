package org.scrum1.sese.view.page.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.util.string.Strings;
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
		
		WebSession session = WebSession.get();
		String username = (String) session.getAttribute("username");
		String role = (String) session.getAttribute("role");
		
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
			
			@Override
			public boolean isVisible() {
				return !Strings.isEmpty(role) && !role.equals("customer");
			}
		};
		this.add(reservationListLink);
		
		Link loginLink = new Link<String>("login") {
			@Override
			public void onClick() {
				CustomerImpl customer = new CustomerImpl();
				this.setResponsePage(new LoginPage(customer));
			}
			
			@Override
			public boolean isVisible() {
				return Strings.isEmpty(username);
			}
		};
		this.add(loginLink);
		
		Label loginName = new Label("loginName", "Willkommen " + username) {
			
			
			@Override
			public boolean isVisible() {
				return !Strings.isEmpty(username);
			}
		};
		this.add(loginName);
		
		Link logoutLink = new Link<String>("logout") {
			@Override
			public void onClick() {
				session.invalidate();
			}
			
			@Override
			public boolean isVisible() {
				return !Strings.isEmpty(username);
			}
		};
		this.add(logoutLink);
		
		Link registerLink = new Link<String>("register") {
			@Override
			public void onClick() {
				CustomerImpl customer = new CustomerImpl();
				this.setResponsePage(new RegisterPage(customer));
			}
			
			@Override
			public boolean isVisible() {
				return Strings.isEmpty(username);
			}
		};
		this.add(registerLink);
	}
	
}
