package org.scrum1.sese.dbo.hibernate;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.scrum1.sese.converter.hibernate.LocalDatePersistenceConverter;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Invoice;
import org.scrum1.sese.dbo.Reservation;
import org.scrum1.sese.dbo.Room;

@Entity(name = "reservation")
@Table(name = "reservation")
@Access(AccessType.FIELD)
public class ReservationImpl extends AbstractDatabaseObjectID implements Reservation {

	private static final long serialVersionUID = -626427961912829509L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	@Column(name = "checkin", nullable = false)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate checkIn;

	@Column(name = "checkout", nullable = false)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate checkOut;

	@Column(name = "discount", nullable = true)
	private Integer discount;

	@Column(name = "price", nullable = false)
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = true)
	private Invoice invoice;

	@Override
	public Customer getCustomer() {
		return this.customer;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Room getRoom() {
		return this.room;
	}

	@Override
	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public LocalDate getCheckIn() {
		return this.checkIn;
	}

	@Override
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	@Override
	public LocalDate getCheckOut() {
		return this.checkOut;
	}

	@Override
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public Integer getDiscount() {
		return this.discount;
	}

	@Override
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public Double getTotalPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invoice getInvoice() {
		return this.invoice;
	}

	@Override
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
