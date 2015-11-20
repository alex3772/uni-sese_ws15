package org.scrum1.sese.dbo;

public interface Defect {

	public Room getRoom();

	public void setRoom(Room room);

	public String getDescription();

	public void setDescription(String description);

	public DefectStatus getDefectStatus();

	public void setDefectStatus(DefectStatus defectStatus);

	public Integer getDiscount();

	public void setDiscount(Integer discount);

}
