package org.scrum1.sese.dbo.hibernate;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.scrum1.sese.converter.hibernate.LocalDatePersistenceConverter;
import org.scrum1.sese.dbo.Gender;
import org.scrum1.sese.dbo.User;

@MappedSuperclass
public abstract class AbstractUserImpl extends AbstractDatabaseObjectID implements User {

	private static final long serialVersionUID = 260605609002184389L;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "surname", length = 100, nullable = false)
	private String surname;

	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "birthdate", nullable = true)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate birthDate;

	@Column(name = "phone", length = 30, nullable = true)
	private String phone;

	@Column(name = "email", length = 30, nullable = true)
	private String email;

	@Column(name = "street", length = 255, nullable = false)
	private String street;

	@Column(name = "city", length = 100, nullable = false)
	private String city;

	@Column(name = "zipcode", length = 10, nullable = false)
	private String zipCode;

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
