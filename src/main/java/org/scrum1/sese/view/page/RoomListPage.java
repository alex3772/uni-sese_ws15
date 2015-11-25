package org.scrum1.sese.view.page;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.service.RoomService;

public class RoomListPage extends BasePage {

	private static final long serialVersionUID = -8144829479277470172L;

	@SpringBean
	private RoomService roomService;

	public RoomListPage(final PageParameters params) {

		if (!params.get("username").isEmpty()) {
			System.out.println("Contains username " + params.get("username"));
		} else {
			System.out.println("No username set");
		}
	}

	public RoomListPage() {
		this.add(getRoomListView(getRoomListModel()));
	}

	private ListView<Room> getRoomListView(IModel<List<Room>> roomListModel) {
		return new ListView<Room>("rooms_list", roomListModel) {

			private static final long serialVersionUID = -155003224331087777L;

			@Override
			protected void populateItem(ListItem<Room> item) {
				Room room = item.getModelObject();
				item.add(new Label("name", room.getName()));
				item.add(new Label("maxPersons", room.getMaxPersons()));
			}
		};
	}

	private IModel<List<Room>> getRoomListModel() {
		return new LoadableDetachableModel<List<Room>>() {

			private static final long serialVersionUID = -1830981661911150014L;

			@Override
			protected List<Room> load() {
				return roomService.findAll();
			}
		};
	}


}
