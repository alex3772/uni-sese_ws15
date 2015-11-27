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

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerImpl.class)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = RoomImpl.class)
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	@Column(name = "checkin", nullable = false)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate checkin;

	@Column(name = "checkout", nullable = false)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate checkout;

	@Column(name = "discount", nullable = true)
	private Integer discount;

	@Column(name = "price", nullable = false)
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = InvoiceImpl.class)
	@JoinColumn(name = "invoice_id", nullable = true)
	private Invoice invoice;

	public ReservationImpl() {
	}

	public ReservationImpl(Customer customer, Room room, LocalDate checkin,
			LocalDate checkout, Integer discount, Double price) {
		this.customer = customer;
		this.room = room;
		this.checkin = checkin;
		this.checkout = checkout;
		this.discount = discount;
		this.price = price;
	}

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
	public LocalDate getCheckin() {
		return this.checkin;
	}

	@Override
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	@Override
	public LocalDate getCheckout() {
		return this.checkout;
	}

	@Override
	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
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
