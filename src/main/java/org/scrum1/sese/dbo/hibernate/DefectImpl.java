package org.scrum1.sese.dbo.hibernate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Defect;
import org.scrum1.sese.dbo.DefectStatus;
import org.scrum1.sese.dbo.Room;

@Entity(name = "defect")
@Table(name = "defect")
@Access(AccessType.FIELD)
public class DefectImpl extends AbstractDatabaseObjectID implements Defect {

	private static final long serialVersionUID = -4267174319079783055L;

	@ManyToOne(targetEntity = RoomImpl.class)
	@JoinColumn(name="room_id", nullable = false)
	private Room room;

	@Column(name = "description", length = 255, nullable = false)
	private String description;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private DefectStatus defectStatus;

	@Column(name = "discount", nullable = true)
	private Integer discount;

	@Override
	public Room getRoom() {
		return this.room;
	}

	@Override
	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public DefectStatus getDefectStatus() {
		return this.defectStatus;
	}

	@Override
	public void setDefectStatus(DefectStatus defectStatus) {
		this.defectStatus = defectStatus;
	}

	@Override
	public Integer getDiscount() {
		return this.discount;
	}

	@Override
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

}
