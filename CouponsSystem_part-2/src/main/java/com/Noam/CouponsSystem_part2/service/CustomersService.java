package com.Noam.CouponsSystem_part2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.repo.CustomerRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomerRepository repo;

	public void addCustomer(Customer customer) {
		repo.save(customer);
	}

	public void updateCustomer(Customer customer) {
		repo.saveAndFlush(customer);
	}

	public void deleteCustomer(Customer customer) {
		repo.delete(customer);
	}

	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	public Customer getOneCustomer(int id) {
		return repo.getOne(id);
	}

	public boolean findByEmailAndPassword(String email, String password) {
		return (repo.findByEmailAndPassword(email, password) != null);
	}
}
