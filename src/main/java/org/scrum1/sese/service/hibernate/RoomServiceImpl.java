package org.scrum1.sese.service.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.scrum1.sese.repository.RoomRepository;
import org.scrum1.sese.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

	private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	@Autowired private RoomRepository roomRepository;

	private List<Room> toList(Iterable<RoomImpl> iterable) {
		List<Room> rooms = new ArrayList<>();
		for(Room room : iterable) {
			rooms.add((RoomImpl) room);
		}
		return rooms;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> findAll() {
		return toList(roomRepository.findAll());
	}

}
