package org.scrum1.sese.dbo.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Gender;
import org.scrum1.sese.dbo.Reservation;

@Entity(name = "customer")
@Table(name = "customer")
@Access(AccessType.FIELD)
public class CustomerImpl extends AbstractUserImpl implements Customer {

	private static final long serialVersionUID = -2597185688650139233L;

	@Column(name = "username", length = 50, nullable = true)
	private String username;

	@Column(name = "password", length = 64, nullable = true)
	private String password;

	@Column(name = "companyname", length = 100, nullable = true)
	private String companyName;

	@Column(name = "fax", length = 30, nullable = true)
	private String fax;

	@Column(name = "web", length = 100, nullable = true)
	private String web;

	@Column(name = "note", length = 255, nullable = true)
	private String note;

	@Column(name = "discount", nullable = true)
	private Integer discount;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", targetEntity = ReservationImpl.class)
	private List<Reservation> reservations;

	public CustomerImpl() {
		super();
	}

	public CustomerImpl(String name, String surname, String password, Gender gender,
			String username, String steet, String city,	String zipCode) {
		super(name, surname, gender, steet, city, zipCode);
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getCompanyName() {
		return this.companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String getFax() {
		return this.fax;
	}

	@Override
	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String getWeb() {
		return this.web;
	}

	@Override
	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public String getNote() {
		return this.note;
	}

	@Override
	public void setNote(String note) {
		this.note = note;
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
		this.getReservations().add(reservation);
	}

	@Override
	public void removeReservation(Reservation reservation) {
		this.getReservations().remove(reservation);
	}

}
