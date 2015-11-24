package org.scrum1.sese.view.page;

import java.util.Date;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.view.forms.CustomerForm;

public class MainPage extends BasePage {

	private static final long serialVersionUID = 4809421004007068373L;

	public MainPage() {
		/* Add needed Links 
		RoomListPageLink roomListLink = new RoomListPageLink("list_rooms");
		this.add(roomListLink);*/

	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		// TODO Auto-generated method stub
		/*response.render(CssHeaderItem.forReference(new CssResourceReference(
				MainPage.class, "bootstrap.css")));*/
	}

}
