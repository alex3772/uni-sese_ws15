package org.scrum1.sese.dbo.hibernate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.scrum1.sese.dbo.Employee;
import org.scrum1.sese.dbo.Gender;
import org.scrum1.sese.dbo.Responsibility;
import org.scrum1.sese.dbo.Role;

@Entity(name = "employee")
@Table(name = "employee")
@Access(AccessType.FIELD)
public class EmployeeImpl extends AbstractUserImpl implements Employee {

	private static final long serialVersionUID = 4741757161073228152L;

	@ManyToOne(targetEntity = RoleImpl.class)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@Column(name = "social_security_number", length = 30, nullable = false, unique = true)
	private String socialSecurityNumber;

	@Column(name = "account_information", length = 35, nullable = true, unique = true)
	private String accountInformation;

	@ManyToOne(targetEntity = ResponsibilityImpl.class)
	@JoinColumn(name = "responsibility_id", nullable = true)
	private Responsibility responsibility;

	public EmployeeImpl() {
		super();
	}

	public EmployeeImpl(String name, String surname, String password, Gender gender,
			String username, String steet, String city,	String zipCode, Role role, String socialSecurityNumber) {
		super(name, surname, password, gender, username, steet, city, zipCode);
		this.role = role;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public Role getRole() {
		return this.getRole();
	}

	@Override
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String getSocialSecurityNumber() {
		return this.socialSecurityNumber;
	}

	@Override
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public String getAccountInformation() {
		return this.accountInformation;
	}

	@Override
	public void setAccountInformation(String accountInformation) {
		this.accountInformation = accountInformation;
	}

	@Override
	public Responsibility getResponsibility() {
		return this.responsibility;
	}

	@Override
	public void setResponsibility(Responsibility responsibility) {
		this.responsibility = responsibility;
	}

}
