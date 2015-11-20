package org.scrum1.sese.dbo;

import java.time.LocalDate;
import java.util.List;

public interface Invoice {

	public LocalDate getInvoiceDate();

	public void setInvoiceDate(LocalDate invoiceDate);

	public List<Reservation> getReservations();

	public void setReservations(List<Reservation> reservations);

	public void addReservation(Reservation reservation);

	public void removeReservation(Reservation reservation);

	public Double getTotalPrice();

}
