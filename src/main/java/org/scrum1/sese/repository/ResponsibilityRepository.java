package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.ResponsibilityImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibilityRepository extends CrudRepository<ResponsibilityImpl, Long> {

}
