package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerImpl, Long> {

	Customer findByUsername(String username);

}
