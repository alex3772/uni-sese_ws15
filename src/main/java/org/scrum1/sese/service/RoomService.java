package org.scrum1.sese.service;

import java.util.List;

import org.scrum1.sese.dbo.Room;

public interface RoomService {

	public Room save(Room room);

	public List<Room> findAll();

}
