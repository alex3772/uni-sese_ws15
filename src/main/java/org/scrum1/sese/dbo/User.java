package org.scrum1.sese.dbo;

import java.time.LocalDate;

public interface User {

	public String getName();

	public void setName(String name);

	public String getSurname();

	public void setSurname(String surname);

	public Gender getGender();

	public void setGender(Gender gender);

	public String getInitial();

	public void setInitial(String initial);

	public String getPassword();

	public void setPassword(String password);

	public LocalDate getBirthDate();

	public void setBirthDate(LocalDate birthdate);

	public String getPhone();

	public void setPhone(String phone);

	public String getEmail();

	public void setEmail(String email);

	public String getStreet();

	public void setStreet(String street);

	public String getCity();

	public void setCity(String city);

	public String getZipCode();

	public void setZipCode(String zipCode);

}
