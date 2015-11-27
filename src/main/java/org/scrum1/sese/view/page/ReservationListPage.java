package org.scrum1.sese.view.page;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.service.ReservationService;
import org.springframework.web.servlet.View;

import javassist.SerialVersionUID;

public class ReservationListPage extends BasePage{
	
	@SpringBean
	private ReservationService reservationService;
	
	public ReservationListPage() {
		this.add(getReservationListView(getReservationListModel()));
	}

	private ListView<Reservation> getReservationListView(IModel<List<Reservation>> reservationListModel) {
		return new ListView<Reservation>("reservations_list", reservationListModel) {
			
			@Override
			protected void populateItem(ListItem<Reservation> item) {
				Reservation reservation = item.getModelObject();
				Room room = reservation.getRoom();
				Customer customer = reservation.getCustomer();
				
				item.add(new Label("roomName", reservation.getRoom().getName()));
				item.add(new Label("customerName", reservation.getCustomer().getName()+" "+reservation.getCustomer().getSurname()));
				item.add(new Label("price", reservation.getPrice()));
				item.add(new Label("discount", reservation.getDiscount()));
			}
		};
	}

	private IModel<List<Reservation>> getReservationListModel() {
		return new LoadableDetachableModel<List<Reservation>>() {
			
			@Override
			protected List<Reservation> load() {
				return reservationService.findAll();
			}
		};
	}

}
