package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.InvoiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceImpl, Long> {

}
