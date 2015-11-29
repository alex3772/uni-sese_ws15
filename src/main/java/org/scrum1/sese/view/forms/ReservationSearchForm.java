package org.scrum1.sese.view.forms;

import org.apache.wicket.extensions.markup.html.form.select.Select;
import org.apache.wicket.extensions.markup.html.form.select.SelectOption;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.scrum1.sese.WicketWebApplication;

public class ReservationSearchForm extends Form{
	
	private String searchText;
	private String searchType;

	public ReservationSearchForm(String id) {
		super(id);
		
		//DropDownChoice<String> searchType = new DropDownChoice<>("searchType","test");
		
		Select searchType = new Select("searchType", new PropertyModel<>(this, "searchType"));
		this.add(searchType);
		searchType.add(new SelectOption("room", new Model<String>("room")));
		searchType.add(new SelectOption("customer", new Model<String>("customer")));
		
		final TextField<String> searchText = new TextField<>("searchText", new PropertyModel<String>(this, "searchText"));
		this.add(searchText);
	}
	
	@Override
	protected void onSubmit() {
		super.onSubmit();
		System.out.println("Search for " + this.searchType + " with search text " + this.searchText);
		// TODO: call findAll with searchParam
	}

}
