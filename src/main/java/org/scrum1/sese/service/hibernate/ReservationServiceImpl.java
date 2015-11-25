package org.scrum1.sese.service.hibernate;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.repository.ReservationRepository;
import org.scrum1.sese.repository.specification.ReservationSpecification;
import org.scrum1.sese.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

public class ReservationServiceImpl implements ReservationService {

	@Autowired private ReservationRepository reservationRepository;

	@Transactional(readOnly = true)
	public List<Reservation> findAll(Customer customer) {
		Specification<ReservationImpl> reservaionSpecification = new ReservationSpecification(customer);

		@SuppressWarnings("unchecked")
		List<Reservation> reservations = IteratorUtils.toList(reservationRepository.findAll(reservaionSpecification).iterator());

		return reservations;
	}

}
