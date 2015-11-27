package org.scrum1.sese.service.hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.scrum1.sese.repository.ReservationRepository;
import org.scrum1.sese.repository.specification.ReservationSpecification;
import org.scrum1.sese.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

	private final static Logger logger = LoggerFactory.getLogger(ReservationImpl.class);

	@Autowired private MessageSource messageSource;
	@Autowired private ReservationRepository reservationRepository;

	private List<Reservation> toList(Iterable<ReservationImpl> iterable) {
		List<Reservation> reservations = new ArrayList<>();
		for(Reservation reservation : iterable) {
			reservations.add(reservation);
		}
		return reservations;
	}

	private IllegalArgumentException generateIllegalArgumentException(String messageKey) {
		String message = messageSource.getMessage(messageKey, null, Locale.getDefault());
		IllegalArgumentException exception = new IllegalArgumentException(message);
		logger.error(message, exception);
		return exception;
	}

	@Override
	@Transactional(readOnly = false)
	public Reservation save(Reservation reservation) {
		if(reservation instanceof ReservationImpl) {
			return reservationRepository.save((ReservationImpl) reservation);
		} else {
			throw generateIllegalArgumentException("error.reservationimpl.type");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Reservation reservation) {
		if(reservation instanceof ReservationImpl) {
			reservationRepository.delete((ReservationImpl) reservation);
		} else {
			throw generateIllegalArgumentException("error.reservationimpl.type");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> findAll() {
		return toList(reservationRepository.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> findAll(Customer customer) {
		if(customer instanceof CustomerImpl) {
			return toList(reservationRepository.findByCustomer(customer));
		} else {
			throw generateIllegalArgumentException("error.customerimpl.type");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> findAll(Room room) {
		if(room instanceof RoomImpl) {
			return toList(reservationRepository.findByRoom(room));
		} else {
			throw generateIllegalArgumentException("error.roomimpl.type");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> findAll(LocalDate checkin, LocalDate checkout) {
		if(checkin != null && checkout != null) {
			return toList(reservationRepository.findByCheckinAndCheckout(checkin, checkout));
		} else if(checkin != null) {
			return toList(reservationRepository.findByCheckin(checkin));
		} else {
			return toList(reservationRepository.findByCheckout(checkout));
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reservation> findAll(Customer customer, Room room, LocalDate checkin, LocalDate checkout) {
		if(!(customer instanceof CustomerImpl)) {
			throw generateIllegalArgumentException("error.customerimpl.type");
		}

		if(!(room instanceof RoomImpl)) {
			throw generateIllegalArgumentException("error.roomimpl.type");
		}

		Specification<ReservationImpl> reservaionSpecification = new ReservationSpecification(customer, room, checkin, checkout);
		return toList(reservationRepository.findAll(reservaionSpecification));
	}

}
