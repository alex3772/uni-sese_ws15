package org.scrum1.sese.dbo;

import java.util.List;

public interface Customer extends User {

	public String getCompanyName();

	public void setCompanyName(String companyName);

	public String getFax();

	public void setFax(String fax);

	public String getWeb();

	public void setWeb(String web);

	public String getNote();

	public void setNote(String note);

	public Integer getDiscount();

	public void setDiscount(Integer discount);

	public List<Reservation> getReservations();

	public void setReservations(List<Reservation> reservations);

	public void addReservation(Reservation reservation);

	public void removeReservation(Reservation reservation);

}
