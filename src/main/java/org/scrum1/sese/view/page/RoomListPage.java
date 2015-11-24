package org.scrum1.sese.view.page;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.scrum1.sese.repository.RoomRepository;
import org.scrum1.sese.service.RoomService;
import org.scrum1.sese.service.hibernate.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomListPage extends BasePage{
	
	@SpringBean
	private RoomService roomService;

	public RoomListPage(final PageParameters params) {

		if (!params.get("username").isEmpty()) {
			System.out.println("Contains username " + params.get("username"));
		} else {
			System.out.println("No username set");
		}
		
		addSampleRooms();
	}
	
	public RoomListPage() {
		this.roomService = new RoomServiceImpl();
		
		System.out.println("SERVICE" + this.roomService);
		
		
		try {
			System.out.println("Inside try");
			List<Room> testList = this.roomService.findAll();
			if(testList.isEmpty()) {
				System.out.println("List is empty");
			} else {
				System.out.println("Not empty");
			}
		} catch (Exception e) {
			System.out.println("ERROR " + e);
		}
		
		addSampleRooms();
	}

	private void addSampleRooms() {
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
