package org.scrum1.sese.dbo.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Employee;
import org.scrum1.sese.dbo.Responsibility;

@Entity(name = "responsibility")
@Table(name = "responsibility")
@Access(AccessType.FIELD)
public class ResponsibilityImpl extends AbstractDatabaseObjectID implements Responsibility {

	private static final long serialVersionUID = 6271436382488518009L;

	@Column(name = "name", length = 30, nullable = false)
	private String name;

	@Column(name = "description", length = 255, nullable = true)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsibility", targetEntity = EmployeeImpl.class)
	private List<Employee> employees;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
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
