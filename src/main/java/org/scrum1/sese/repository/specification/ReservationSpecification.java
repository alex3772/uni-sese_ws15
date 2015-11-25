package org.scrum1.sese.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.dbo.hibernate.metamodel.ReservationModel;
import org.springframework.data.jpa.domain.Specification;

public class ReservationSpecification implements Specification<ReservationImpl> {

	private Customer customer;

	public ReservationSpecification(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Predicate toPredicate(Root<ReservationImpl> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get(ReservationModel.customer), customer);
	}

}
