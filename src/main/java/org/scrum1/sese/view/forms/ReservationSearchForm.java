package org.scrum1.sese.view.forms;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.scrum1.sese.WicketWebApplication;

public class ReservationSearchForm extends Form{
	
	private String searchText;

	public ReservationSearchForm(String id) {
		super(id);
		
		final TextField<String> searchText = new TextField<>("searchText", new PropertyModel<String>(this, "searchText"));
		this.add(searchText);
	}
	
	@Override
	protected void onSubmit() {
		super.onSubmit();

		// TODO: call findAll with searchParam
	}

}
