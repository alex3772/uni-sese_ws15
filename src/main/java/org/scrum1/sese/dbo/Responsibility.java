package org.scrum1.sese.dbo;

import java.util.List;

public interface Responsibility {

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public List<Employee> getEmployees();

	public void setEmployees(List<Employee> employees);

	public void addEmployee(Employee employee);

	public void removeEmployee(Employee employee);

}
