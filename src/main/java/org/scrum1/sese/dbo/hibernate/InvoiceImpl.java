package org.scrum1.sese.dbo.hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.scrum1.sese.converter.hibernate.LocalDatePersistenceConverter;
import org.scrum1.sese.dbo.Invoice;
import org.scrum1.sese.dbo.Reservation;

@Entity(name = "invoice")
@Table(name = "invoice")
@Access(AccessType.FIELD)
public class InvoiceImpl extends AbstractDatabaseObjectID implements Invoice {

	private static final long serialVersionUID = 3461669020043601051L;

	@Column(name = "invoice_date", nullable = false)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate invoiceDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", targetEntity = ReservationImpl.class)
	private List<Reservation> reservations;

	@Override
	public LocalDate getInvoiceDate() {
		return this.invoiceDate;
	}

	@Override
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Override
	public List<Reservation> getReservations() {
		if(reservations == null) {
			this.reservations = new ArrayList<>();
		}
		return this.reservations;
	}

	@Override
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public void addReservation(Reservation reservation) {
		getReservations().add(reservation);
	}

	@Override
	public void removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
	}

	@Override
	public Double getTotalPrice() {
		// TODO Auto-generated method stub
		return null;
	}

}
