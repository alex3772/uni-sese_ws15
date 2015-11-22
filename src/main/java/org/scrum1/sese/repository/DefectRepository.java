package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.DefectImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends CrudRepository<DefectImpl, Long> {

}
