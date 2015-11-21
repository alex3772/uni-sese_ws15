package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.RoleImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleImpl, Long> {

}
