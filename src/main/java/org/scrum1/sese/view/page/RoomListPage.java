package org.scrum1.sese.view.page;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.scrum1.sese.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomListPage extends BasePage{
	
	@Autowired
	private RoomRepository roomsList;

	public RoomListPage() {
		//this.roomsList = new RoomRempoImpl();
		try {
			List<RoomImpl> testList = (List<RoomImpl>) roomsList.findAll();//(List<RoomImpl>) this.roomsList.findAll();	
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		List<RoomImpl> rooms = new LinkedList<RoomImpl>();
		
		RoomImpl r1 = new RoomImpl();
		r1.setName("test");
		r1.setMaxPersons(10);
		
		RoomImpl r2 = new RoomImpl();
		r2.setName("test 2");
		r2.setMaxPersons(2);
		
		rooms.add(r1);
		rooms.add(r2);
		
		System.out.println("Created rooms");
		
		ListView roomsListView = new ListView("rooms_list", rooms) {
			@Override
			protected void populateItem(ListItem item) {
				RoomImpl r = (RoomImpl) item.getModelObject();
				item.add(new Label("name", r.getName()));
				item.add(new Label("maxPersons", r.getMaxPersons()));
			}
		};
		
		this.add(roomsListView);
	}
	
}
