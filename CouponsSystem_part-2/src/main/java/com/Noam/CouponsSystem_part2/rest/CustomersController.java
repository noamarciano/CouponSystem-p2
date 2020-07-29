package com.Noam.CouponsSystem_part2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.service.CustomersService;

@RestController
@RequestMapping("customer")
public class CustomersController {

	@Autowired
	CustomersService customersService;

	@PostMapping("add")
	public ResponseEntity<?> addCustomer(Customer customer) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("update")
	public ResponseEntity<?> updateCustomer(Customer customer) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> deleteCustomer(Customer customer) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("get-all")
	public ResponseEntity<?> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customersService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("get-one")
	public ResponseEntity<?> getOneCustomer(int id) {
		return new ResponseEntity<Customer>(customersService.getOneCustomer(id), HttpStatus.OK);
	}

}
