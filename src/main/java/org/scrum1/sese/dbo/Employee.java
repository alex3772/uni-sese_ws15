package org.scrum1.sese.dbo;

public interface Employee extends User {

	public Role getRole();

	public void setRole(Role role);

	public String getInitial();

	public void setInitial(String initial);

	public String getSocialSecurityNumber();

	public void setSocialSecurityNumber(String socialSecurityNumber);

	public String getAccountInformation();

	public void setAccountInformation(String accountInformation);

	public Responsibility getResponsibility();

	public void setResponsibility(Responsibility responsibility);

	// TODO Anstellungsverhaeltnis

}
