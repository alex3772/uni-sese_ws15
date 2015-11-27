package org.scrum1.sese.service;

import java.util.List;

import org.scrum1.sese.dbo.Customer;

public interface CustomerService {

	public Customer save(Customer customer);

	public List<Customer> findAll();

}
