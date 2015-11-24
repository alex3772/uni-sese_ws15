package org.scrum1.sese.service.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.scrum1.sese.repository.RoomRepository;
import org.scrum1.sese.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class RoomServiceImpl implements RoomService {

	@Autowired private RoomRepository roomRepository;

	private List<Room> toList(Iterable<RoomImpl> iterable) {
		List<Room> rooms = new ArrayList<>();
		for(Room room : iterable) {
			rooms.add(room);
		}
		return rooms;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> findAll() {
		return toList(roomRepository.findAll());
	}

}
