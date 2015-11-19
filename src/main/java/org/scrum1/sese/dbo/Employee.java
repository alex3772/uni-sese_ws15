package org.scrum1.sese.dbo;

public interface Employee extends User {

	public Role getRole();

	public void setRole(Role role);

	public String getInitial();

	public void setInitial(String initial);

}
