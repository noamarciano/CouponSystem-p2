package com.Noam.CouponsSystem_part2.service;

import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;

import lombok.Data;

@Data
public abstract class ClientFacade {

	protected CompaniesService companiesService;
	protected CustomersService customersService;
	protected CouponsService couponsService;
	
	
	public abstract boolean login(String email, String password) throws LoginDeniedException;
	
	
	
	
}
