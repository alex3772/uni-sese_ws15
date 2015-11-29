package org.scrum1.sese.service;

import java.time.LocalDate;
import java.util.List;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.Room;

public interface ReservationService {

	public Reservation save(Reservation reservation);

	public void delete(Reservation reservation);

	public Reservation reload(Reservation reservation);

	public List<Reservation> findAll();

	public List<Reservation> findAll(Customer customer);

	public List<Reservation> findAll(Room room);

	public List<Reservation> findAll(LocalDate checkin, LocalDate checkout);

	public List<Reservation> findAll(Customer customer, Room room, LocalDate checkin, LocalDate checkout);
	
	//public List<Reservation> findByCustomer(String customerName);

}
