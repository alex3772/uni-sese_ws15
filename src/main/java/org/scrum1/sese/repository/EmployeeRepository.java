package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.EmployeeImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeImpl, Long> {

}
