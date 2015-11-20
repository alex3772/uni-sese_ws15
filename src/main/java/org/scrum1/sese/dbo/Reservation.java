package org.scrum1.sese.dbo;

import java.time.LocalDate;

public interface Reservation {

	public Customer getCustomer();

	public void setCustomer(Customer customer);

	public Room getRoom();

	public void setRoom(Room room);

	public LocalDate getCheckIn();

	public void setCheckIn(LocalDate checkIn);

	public LocalDate getCheckOut();

	public void setCheckOut();

	public Integer getDiscount();

	public void setDiscount(Integer discount);

	public Double getPrice();

	public void setPrice(Double price);

	public Double getTotalPrice();

}
