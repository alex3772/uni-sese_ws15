package org.scrum1.sese.repository.specification;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.dbo.hibernate.ReservationImpl_;
import org.springframework.data.jpa.domain.Specification;

public class ReservationSpecification implements Specification<ReservationImpl> {

	private Customer customer;
	private Room room;
	private LocalDate checkin;
	private LocalDate checkout;

	public ReservationSpecification(Customer customer, Room room, LocalDate checkin, LocalDate checkout) {
		this.customer = customer;
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	@Override
	public Predicate toPredicate(Root<ReservationImpl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate predicate = null;
		if(customer != null) {
			predicate = cb.equal(root.get(ReservationImpl_.customer), customer);
		}

		if(room != null) {
			Predicate roomPredicate = cb.equal(root.get(ReservationImpl_.room), room);
			if(predicate == null) {
				predicate = roomPredicate;
			} else {
				predicate = cb.and(predicate, roomPredicate);
			}
		}

		if(checkin != null) {
			Predicate checkinPredicate = cb.equal(root.get(ReservationImpl_.checkin), checkin);
			if(predicate == null) {
				predicate = checkinPredicate;
			} else {
				predicate = cb.and(predicate, checkinPredicate);
			}
		}

		if(checkout != null) {
			Predicate checkoutPredicate = cb.equal(root.get(ReservationImpl_.checkout), checkout);
			if(predicate == null) {
				predicate = checkoutPredicate;
			} else {
				predicate = cb.and(predicate, checkoutPredicate);
			}
		}

		return predicate;
	}

}
