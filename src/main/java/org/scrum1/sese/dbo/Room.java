package org.scrum1.sese.dbo;

import java.util.List;

public interface Room {

	public String getName();

	public void setName(String name);

	public Integer getMaxPersons();

	public void setMaxPersons(Integer maxPersons);

	public Double getPriceSR();

	public void setPriceSR(Double price);

	public Double getPriceDR();

	public void setPriceDR(Double price);

	public Double getPriceTR();

	public void setPriceTR(Double price);

	public Double getPriceSROneChild();

	public void setPriceSROneChild(Double price);

	public Double getPriceSRTwoChildren();

	public void setPriceSRTwoChildren(Double price);

	public Double getPriceDROneChild();

	public void setPriceDROneChild(Double price);

	public List<Reservation> getReservations();

	public void setReservations(List<Reservation> reservations);

	public void addReservation(Reservation reservation);

	public void removeReservation(Reservation reservation);

	public List<Defect> getDefects();

	public void setDefects(List<Defect> defects);

	public void addDefect(Defect defect);

	public void removeDefect(Defect defect);

}
