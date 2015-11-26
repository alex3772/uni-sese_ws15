package org.scrum1.sese.dbo;

import java.time.LocalDate;

public interface Reservation {

	public Customer getCustomer();

	public void setCustomer(Customer customer);

	public Room getRoom();

	public void setRoom(Room room);

	public LocalDate getCheckin();

	public void setCheckin(LocalDate checkin);

	public LocalDate getCheckout();

	public void setCheckout(LocalDate checkout);

	public Integer getDiscount();

	public void setDiscount(Integer discount);

	public Double getPrice();

	public void setPrice(Double price);

	public Double getTotalPrice();

	public Invoice getInvoice();

	public void setInvoice(Invoice invoice);

}
