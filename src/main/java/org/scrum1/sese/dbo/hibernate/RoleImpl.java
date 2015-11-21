package org.scrum1.sese.dbo.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Employee;
import org.scrum1.sese.dbo.Role;

@Entity(name = "role")
@Table(name = "role")
@Access(AccessType.FIELD)
public class RoleImpl extends AbstractDatabaseObjectID implements Role {

	private static final long serialVersionUID = 160070053639371945L;

	@Column(name = "key", length = 30, nullable = false, unique = true)
	private String key;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@OneToMany(mappedBy = "role", targetEntity = EmployeeImpl.class)
	private List<Employee> employees;

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Employee> getEmployees() {
		if(employees == null) {
			this.employees = new ArrayList<>();
		}
		return this.employees;
	}

	@Override
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public void addEmployee(Employee employee) {
		getEmployees().add(employee);
	}

	@Override
	public void removeEmployee(Employee employee) {
		getEmployees().remove(employee);
	}

}
