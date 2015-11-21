package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationImpl, Long> {

}
