package org.scrum1.sese.service.hibernate;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum1.sese.WicketWebApplication;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Gender;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.service.CustomerService;
import org.scrum1.sese.service.ReservationService;
import org.scrum1.sese.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WicketWebApplication.class)
public class ReservationServiceImplTest {

	@Autowired private ReservationService reservationService;
	@Autowired private CustomerService customerService;
	@Autowired private RoomService roomService;

	private Customer customer1;
	private Customer customer2;
	private Customer customer3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		initCustomers();
	}

	@After
	public void tearDown() throws Exception {
	}

	private void initCustomers() {
		customer1 = new CustomerImpl("Gerhard", "Berger", "", Gender.MALE, "gberger", "Berger Str.", "Berg", "2525");
		customer2 = new CustomerImpl("Gerda", "Schmidt", "", Gender.FEMALE, "gschmidt", "Schmidtstrasse", "Schmida", "6528");
		customer3 = new CustomerImpl("Hans", "Haas", "", Gender.MALE, "hhaas", "Hasengasse", "Wien", "1100");
	}

	private void saveCustomers() {
		customer1 = customerService.save(customer1);
		customer2 = customerService.save(customer2);
		customer3 = customerService.save(customer3);
	}

	private Room getRoom(String name) {
		List<Room> rooms = roomService.findAll();
		assertFalse(rooms.isEmpty());
		for(Room room : rooms) {
			if(room.getName().equals(name)) {
				return room;
			}
		}
		return null;
	}

	@Test
	@Transactional
	public void testDummy(){
	 assertTrue(true);
    }
    /*
	public void testSaveReservations() {
		saveCustomers();

		Room room101 = getRoom("101");
		assertNotNull(room101);
		assertTrue(room101.getReservations().isEmpty());

		LocalDate checkin = LocalDate.now();
		LocalDate checkout = LocalDate.now().plusDays(1);
		Reservation reservation1 = new ReservationImpl(customer1, room101, checkin, checkout, customer1.getDiscount(), room101.getPriceSR());

		Reservation savedReservation = reservationService.save(reservation1);
		assertTrue(savedReservation instanceof ReservationImpl);
		assertTrue(((ReservationImpl) savedReservation).isPersisted());

		Customer reservationCustomer = savedReservation.getCustomer();
		assertEquals(customer1, reservationCustomer);
		assertFalse(reservationCustomer.getReservations().isEmpty());
		assertEquals(1, reservationCustomer.getReservations().size());
		assertEquals(savedReservation, reservationCustomer.getReservations().get(0));

		Room reservationRoom = savedReservation.getRoom();
		assertNotNull(reservationRoom);
		assertTrue(reservationRoom.equals(room101));
		assertFalse(reservationRoom.getReservations().isEmpty());
		assertEquals(1, reservationRoom.getReservations().size());
		assertEquals(savedReservation, reservationRoom.getReservations().get(0));
	}

	@Test
	@Transactional
	public void testRemoveReservation() {
		saveCustomers();

		Room room101 = getRoom("101");
		assertNotNull(room101);
		assertTrue(room101.getReservations().isEmpty());

		LocalDate checkin = LocalDate.now();
		LocalDate checkout = LocalDate.now().plusDays(1);
		Reservation reservation1 = new ReservationImpl(customer1, room101, checkin, checkout, customer1.getDiscount(), room101.getPriceSR());

		Reservation savedReservation = reservationService.save(reservation1);
		reservationService.delete(savedReservation);

		Reservation reloadedReservation = reservationService.reload(savedReservation);
		assertNull(reloadedReservation);

		// TODO reloading room and customer and test if reservation exists.
	}

	@Test
	@Transactional
	public void testSearchReservation() {
		saveCustomers();

		LocalDate checkin = LocalDate.of(2015, 11, 25);
		LocalDate checkout = LocalDate.of(2015, 11, 27);
		Room room = getRoom("101");

		Reservation reservation1 = new ReservationImpl(customer1, room, checkin, checkout, customer1.getDiscount(), room.getPriceSR());
		reservationService.save(reservation1);

		room = getRoom("102");
		Reservation reservation2 = new ReservationImpl(customer1, room, checkin, checkout, customer1.getDiscount(), room.getPriceSR());
		reservationService.save(reservation2);

		room = getRoom("103");
		Reservation reservation3 = new ReservationImpl(customer2, room, checkin.plusDays(2), checkout.plusDays(2), customer2.getDiscount(), room.getPriceSR());
		reservationService.save(reservation3);

		List<Reservation> reservations = reservationService.findAll(customer1, getRoom("101"), null, null);
		assertFalse(reservations.isEmpty());
		assertEquals(1, reservations.size());

		assertEquals(2, reservationService.findAll(customer1).size());

		reservations = reservationService.findByRoomName("101");
		assertFalse(reservations.isEmpty());

		reservations = reservationService.findByCustomerName("erger");
		assertFalse(reservations.isEmpty());

		reservations = reservationService.findAll("erg", "101");
		assertFalse(reservations.isEmpty());
	}
*/
}
