package org.scrum1.sese.service.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

	private static Customer customer1;
	private static Customer customer2;
	private static Customer customer3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initCustomers();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private static void initCustomers() {
		customer1 = new CustomerImpl("Gerhard", "Berger", "", Gender.MALE, "gberger", "Berger Str.", "Berg", "2525");
		customer2 = new CustomerImpl("Gerda", "Schmidt", "", Gender.FEMALE, "gschmidt", "Schmidtstrasse", "Schmida", "6528");
		customer3 = new CustomerImpl("Hans", "Haas", "", Gender.MALE, "hhaas", "Hasengasse", "Wien", "1100");
	}

	@Test
	@Transactional
	public void testSaveReservations() {
		List<Room> rooms = roomService.findAll();
		assertNotNull(rooms);
		assertFalse(rooms.isEmpty());

		Room room101 = rooms.get(0);
		assertNotNull(room101);
		assertEquals("101", room101.getName());

		Customer savedCustomer1 = customerService.save(customer1);
		assertTrue(savedCustomer1 instanceof CustomerImpl);
		assertTrue(((CustomerImpl) savedCustomer1).isPersisted());

		LocalDate checkin = LocalDate.now();
		LocalDate checkout = LocalDate.now().plusDays(1);
		Reservation reservation1 = new ReservationImpl(savedCustomer1, room101, checkin, checkout, savedCustomer1.getDiscount(), room101.getPriceSR());

		Reservation savedReservation = reservationService.save(reservation1);
		assertTrue(savedReservation instanceof ReservationImpl);
		assertTrue(((ReservationImpl) savedReservation).isPersisted());

//		assertFalse(savedReservation.getCustomer().getReservations().isEmpty());

		List<Customer> customers = customerService.findAll();
		Customer reloadedCustomer = customers.get(0);
		assertEquals(customer1.getName(), reloadedCustomer.getName());
		assertFalse(reloadedCustomer.getReservations().isEmpty());
	}

}
