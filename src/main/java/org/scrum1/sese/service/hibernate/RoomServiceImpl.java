package org.scrum1.sese.service.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.scrum1.sese.dbo.Room;
import org.scrum1.sese.dbo.hibernate.RoomImpl;
import org.scrum1.sese.repository.RoomRepository;
import org.scrum1.sese.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

	private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	@Autowired private MessageSource messageSource;
	@Autowired private RoomRepository roomRepository;

	private List<Room> toList(Iterable<RoomImpl> iterable) {
		List<Room> rooms = new ArrayList<>();
		for(Room room : iterable) {
			rooms.add((RoomImpl) room);
		}
		return rooms;
	}

	private IllegalArgumentException generateIllegalArgumentException(String messageKey) {
		String message = messageSource.getMessage(messageKey, null, Locale.getDefault());
		IllegalArgumentException exception = new IllegalArgumentException(message);
		logger.error(message, exception);
		return exception;
	}

	@Override
	@Transactional(readOnly = false)
	public Room save(Room room) {
		if(room instanceof RoomImpl) {
			return roomRepository.save((RoomImpl) room);
		} else {
			throw generateIllegalArgumentException("error.roomimpl.type");
		}
	}



	@Override
	@Transactional(readOnly = true)
	public List<Room> findAll() {
		return toList(roomRepository.findAll());
	}

}
