package org.scrum1.sese.dbo.hibernate;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.scrum1.sese.converter.hibernate.LocalDatePersistenceConverter;
import org.scrum1.sese.dbo.Address;
import org.scrum1.sese.dbo.Gender;
import org.scrum1.sese.dbo.User;

@MappedSuperclass
public abstract class AbstractUserImpl extends AbstractDatabaseObjectID implements User {

	private static final long serialVersionUID = 260605609002184389L;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "surname", length = 100, nullable = false)
	private String surname;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "birthdate", nullable = true)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate birthDate;

	@Column(name = "phone", length = 30, nullable = true)
	private String phone;

	@Column(name = "email", length = 30, nullable = true)
	private String email;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getSurname() {
		return this.surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public Gender getGender() {
		return this.gender;
	}

	@Override
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	@Override
	public void setBirthDate(LocalDate birthdate) {
		this.birthDate = birthdate;
	}

	@Override
	public String getPhone() {
		return this.phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Address getAddress() {
		return this.address;
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;
	}

}
