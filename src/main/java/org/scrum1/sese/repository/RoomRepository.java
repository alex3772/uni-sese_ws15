package org.scrum1.sese.repository;

import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomImpl, Long> {

}
