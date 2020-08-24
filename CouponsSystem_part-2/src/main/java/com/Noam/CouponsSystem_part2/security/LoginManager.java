package com.Noam.CouponsSystem_part2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;
import com.Noam.CouponsSystem_part2.service.AdminFacade;
import com.Noam.CouponsSystem_part2.service.ClientFacade;
import com.Noam.CouponsSystem_part2.service.CompanyFacade;
import com.Noam.CouponsSystem_part2.service.CustomerFacade;

@Component
public class LoginManager {

	@Autowired
	private AdminFacade adminFacade;

	@Autowired
	private CompanyFacade companyFacade;

	@Autowired
	private CustomerFacade customerFacade;

	public ClientFacade login(String email, String password, ClientType clientType) throws LoginDeniedException {

		switch (clientType) {
		case Administrator:
			if (adminFacade.login(email, password)) {
				System.out.println("Admin Facade - Login successful");
				return adminFacade;
			} else {
				return null;
			}
		case Company:

			if (companyFacade.login(email, password)) {
				System.out.println("Company Facade - Login successful");
				return companyFacade;
			} else {
				return null;
			}

		case Customer:
			if (customerFacade.login(email, password)) {
				System.out.println("Cuatomer Facade - Login successful");
				return customerFacade;
			} else {
				return null;
			}
		default:
			System.out.println("One or more details are wrong, please try again..");
			return null;
		}
	}

}
