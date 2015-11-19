package org.scrum1.sese.dbo;

import java.time.LocalDate;

public interface User {

	public String getName();

	public void setName(String name);

	public String getSurname();

	public void setSurname(String surname);

	public Gender getGender();

	public void setGender(Gender gender);

	public LocalDate getBirthDate();

	public void setBirthDate();

	public String getPhone();

	public void setPhone();

	public String getEmail();

	public void setEmail();

	public Address getAddress();

	public void setAddress(Address address);

}
