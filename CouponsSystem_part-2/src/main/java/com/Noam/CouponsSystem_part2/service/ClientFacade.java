package com.Noam.CouponsSystem_part2.service;

import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public abstract class ClientFacade {

	
	protected CompaniesService companiesService;
	
	protected CustomersService customersService;
	
	protected CouponsService couponsService;

	public abstract boolean login(String email, String password) throws LoginDeniedException;
}
