package org.scrum1.sese.service.hibernate;

import org.apache.wicket.protocol.http.WebSession;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.Employee;
import org.scrum1.sese.dbo.Role;
import org.scrum1.sese.repository.EmployeeRepository;
import org.scrum1.sese.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired private EmployeeRepository employeeRepository;
	
	@Override
	public boolean authenticate(String username, String password) {
		Employee ret = employeeRepository.findByUsername(username);
		if (ret != null && ret.getPassword().equals(password)) {
			WebSession session = WebSession.get();
			session.setAttribute("username", username);
			// TODO: use .getRole() method
			session.setAttribute("role", "employee");
			return true;
		}
		return false;
	}

}
