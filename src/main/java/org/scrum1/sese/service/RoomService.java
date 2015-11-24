package org.scrum1.sese.service;

import java.io.Serializable;
import java.util.List;

import org.scrum1.sese.dbo.Room;

public interface RoomService extends Serializable{

	public List<Room> findAll();

}
