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
	private static ClientFacade clientFacade;

	public static ClientFacade login(String email, String password, ClientType clientType) throws LoginDeniedException {

		switch (clientType) {
		case Administrator:
			clientFacade = new AdminFacade();
			if (clientFacade.login(email, password)) {
				System.out.println("Admin Facade - Login successful");
				return clientFacade;
			} else {
				return null;
			}
		case Company:
			clientFacade = new CompanyFacade();
			if (clientFacade.login(email, password)) {
				System.out.println("Company Facade - Login successful");
				return clientFacade;
			} else {
				return null;
			}

		case Customer:
			clientFacade = new CustomerFacade();
			if (clientFacade.login(email, password)) {
				System.out.println("Cuatomer Facade - Login successful");
				return clientFacade;
			} else {
				return null;
			}
		default:
			clientFacade = null;
			System.out.println("One or more details are wrong, please try again..");
			break;
		}
		return null;

	}

}
