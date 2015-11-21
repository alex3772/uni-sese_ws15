package org.scrum1.sese.dbo.hibernate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Address;
import org.scrum1.sese.dbo.User;

@Entity(name = "address")
@Table(name = "address")
@Access(AccessType.FIELD)
public class AddressImpl extends AbstractDatabaseObjectID implements Address {

	private static final long serialVersionUID = 8572091614029105243L;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="address")
	private User user;

	@Column(name = "street", length = 255, nullable = false)
	private String street;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "zipcode", length = 10, nullable = false)
	private String zipCode;

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getStreet() {
		return this.street;
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String getCity() {
		return this.city;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getZipCode() {
		return this.zipCode;
	}

	@Override
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
