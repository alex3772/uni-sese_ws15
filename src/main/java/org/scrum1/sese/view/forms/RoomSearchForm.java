package org.scrum1.sese.view.forms;

import org.apache.wicket.extensions.markup.html.form.select.Select;
import org.apache.wicket.extensions.markup.html.form.select.SelectOption;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.scrum1.sese.view.page.RoomListPage;

public class RoomSearchForm extends Form{

	private String searchText;
	private String searchType;

	public RoomSearchForm(String id) {
		super(id);
		
		Select searchType = new Select("searchType", new PropertyModel<>(this, "searchType"));
		this.add(searchType);
		searchType.add(new SelectOption("room", new Model<String>("room")));
		searchType.add(new SelectOption("maxPerson", new Model<String>("maxPerson")));

		final TextField<String> searchText = new TextField<>("searchText", new PropertyModel<String>(this, "searchText"));
		this.add(searchText);
	}
	
	@Override
	protected void onSubmit() {
		super.onSubmit();
		System.out.println("Search for room " + this.searchText);
		// TODO: call findAll with searchParam
		PageParameters param = new PageParameters();
		param.add("searchText", this.searchText);
		param.add("searchType", this.searchType);
		getRequestCycle().setResponsePage(RoomListPage.class, param);
	}
}
