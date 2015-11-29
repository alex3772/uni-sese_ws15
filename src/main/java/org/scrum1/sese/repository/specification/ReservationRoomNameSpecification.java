package org.scrum1.sese.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.dbo.hibernate.ReservationImpl_;
import org.scrum1.sese.dbo.hibernate.RoomImpl_;
import org.springframework.data.jpa.domain.Specification;

public class ReservationRoomNameSpecification implements Specification<ReservationImpl> {

	private String name;

	public ReservationRoomNameSpecification(String name) {
		this.name = name;
	}

	@Override
	public Predicate toPredicate(Root<ReservationImpl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.like(cb.lower(root.get(ReservationImpl_.room).get(RoomImpl_.name)), "%" + name.toLowerCase() + "%");
	}

}
