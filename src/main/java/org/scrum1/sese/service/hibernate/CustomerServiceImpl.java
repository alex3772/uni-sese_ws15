package org.scrum1.sese.service.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.wicket.protocol.http.WebSession;
import org.scrum1.sese.WicketWebApplication;
import org.scrum1.sese.dbo.Customer;
import org.scrum1.sese.dbo.User;
import org.scrum1.sese.dbo.hibernate.CustomerImpl;
import org.scrum1.sese.repository.CustomerRepository;
import org.scrum1.sese.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired private MessageSource messageSource;
	@Autowired private CustomerRepository customerRepository;

	private List<Customer> toList(Iterable<CustomerImpl> iterable) {
		List<Customer> customers = new ArrayList<>();
		for(Customer customer : iterable) {
			customers.add(customer);
		}
		return customers;
	}

	private IllegalArgumentException generateIllegalArgumentException(String messageKey) {
		String message = messageSource.getMessage(messageKey, null, Locale.getDefault());
		IllegalArgumentException exception = new IllegalArgumentException(message);
		logger.error(message, exception);
		return exception;
	}

	@Override
	@Transactional(readOnly = false)
	public Customer save(Customer customer) {
		if(customer instanceof CustomerImpl) {
			return customerRepository.save((CustomerImpl) customer);
		} else {
			throw generateIllegalArgumentException("error.customerimpl.type");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return toList(customerRepository.findAll());
	}
	
	@Override
	public boolean authenticate(String username, String password) {
		Customer ret = customerRepository.findByUsername(username);
		if (ret != null && ret.getPassword().equals(password)) {
			WebSession session = WebSession.get();
			session.setAttribute("username", username);
			session.setAttribute("role", "customer");
			return true;
		}
		return false;
	}

}
