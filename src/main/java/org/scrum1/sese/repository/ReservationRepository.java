package org.scrum1.sese.repository;

import java.time.LocalDate;
import java.util.List;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationImpl, Long>,
	JpaSpecificationExecutor<ReservationImpl> {

	public List<ReservationImpl> findByCustomer(Customer customer);

	public List<ReservationImpl> findByRoom(Room room);

	public List<ReservationImpl> findByCheckin(LocalDate checkin);

	public List<ReservationImpl> findByCheckout(LocalDate checkou);

	public List<ReservationImpl> findByCheckinAndCheckout(LocalDate checkin, LocalDate checkout);

	public List<ReservationImpl> findByCustomerAndRoom(Customer customer, Room room);

}
