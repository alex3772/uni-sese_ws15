package org.scrum1.sese.repository;

import java.util.List;

import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.ReservationImpl;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<RoomImpl, Long> {
	
	public List<RoomImpl> findByName(String room);

	public List<RoomImpl> findByMaxPersons(int parseInt);

}
