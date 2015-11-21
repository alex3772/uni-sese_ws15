package org.scrum1.sese.dbo;

import java.util.List;

public interface Role {

	public String getKey();

	public void setKey(String key);

	public String getName();

	public void setName(String name);

	public List<Employee> getEmployees();

	public void setEmployees(List<Employee> employees);

	public void addEmployee(Employee employee);

	public void removeEmployee(Employee employee);
}
