package com.Noam.CouponsSystem_part2.clr;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.exceptions.AlreadyExistException;
import com.Noam.CouponsSystem_part2.exceptions.CannotUpdateException;
import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;
import com.Noam.CouponsSystem_part2.exceptions.NoSuchThingLikeThisException;
import com.Noam.CouponsSystem_part2.security.ClientType;
import com.Noam.CouponsSystem_part2.security.LoginManager;
import com.Noam.CouponsSystem_part2.service.AdminFacade;
import com.Noam.CouponsSystem_part2.utils.CheckTitle;

@Component
@Order(4)
public class AdminFacadeTest implements CommandLineRunner {

	@Autowired
	AdminFacade adminFacade;

	@Autowired
	LoginManager loginManager;

	@Override
	public void run(String... args) throws Exception {

		CheckTitle.adminFacadeCheck();

		CheckTitle.printTestLine("Admin Facade - !WRONG! login test");
		try {
			loginManager.login("admin111@admin.com", "admin111", ClientType.Administrator);
		} catch (LoginDeniedException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printTestLine("Admin Facade - Real login test");
		try {
			loginManager.login("admin@admin.com", "admin", ClientType.Administrator);
		} catch (LoginDeniedException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printTestLine("Admin Facade - add companies");

		try {

			Company c1 = new Company();
			c1.setName("Hilton");
			c1.setEmail("hilton@company.com");
			c1.setPassword("1234");

			Company c2 = new Company();
			c2.setName("Herodes");
			c2.setEmail("herodes@company.com");
			c2.setPassword("1234");

			adminFacade.addCompany(c1);
			adminFacade.addCompany(c2);
			CheckTitle.printCompaniesTable(adminFacade.getAllCompanies());

		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printTestLine("Admin Facade - !WRONG! add companies");
		Company c6 = new Company();
		c6.setName("Hilton");
		c6.setEmail("hilton111@company.com");
		c6.setPassword("1234");

		Company c7 = new Company();
		c7.setName("Hilton111");
		c7.setEmail("hilton@company.com");
		c7.setPassword("1234");

		try {
			adminFacade.addCompany(c6);
			adminFacade.addCompany(c7);
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		CheckTitle.printCompaniesTable(adminFacade.getAllCompanies());

		CheckTitle.printTestLine("Admin Facade - update company");

		try {
			Company company = adminFacade.getOneCompany1(4);

			company.setEmail("hilton123@company.com");
			company.setPassword("9876");
			adminFacade.updateCompany(4, company);
		} catch (CannotUpdateException e2) {
			System.out.println(e2.getMessage());
		}
		CheckTitle.printOneCompany(adminFacade.getOneCompany1(4));

		CheckTitle.printTestLine("Admin Facade - !WRONG! update company");
		try {
			Company company = adminFacade.getOneCompany1(4);
			company.setName("New Hilton");
			company.setId(123);

			adminFacade.updateCompany(4, company);
		} catch (CannotUpdateException e1) {
			System.out.println(e1.getMessage());
		}

		CheckTitle.printTestLine("Admin Facade - delete company");
		adminFacade.deleteCompany(5);
		CheckTitle.printCompaniesTable(adminFacade.getAllCompanies());

		CheckTitle.printTestLine("Admin Facade - !WRONG! delete company");
		adminFacade.deleteCompany(22);
		CheckTitle.printCompaniesTable(adminFacade.getAllCompanies());

		CheckTitle.printTestLine("Admin Facade - add customers");

		Customer cu4 = new Customer();
		cu4.setFirstName("Dana");
		cu4.setLastName("Levi");
		cu4.setEmail("dana@gmail.com");
		cu4.setPassword("1234");

		Customer cu5 = new Customer();
		cu5.setFirstName("Avi");
		cu5.setLastName("Barda");
		cu5.setEmail("avi@gmail.com");
		cu5.setPassword("1234");

		try {
			CheckTitle.printCustomersTable(adminFacade.getAllCustomers());
			System.out.println();
			adminFacade.addCustomer(cu4);
			adminFacade.addCustomer(cu5);
			System.out.println();
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		CheckTitle.printCustomersTable(adminFacade.getAllCustomers());

		CheckTitle.printTestLine("Admin Facade - !WRONG! add customers");

		Customer cu6 = new Customer();
		cu6.setFirstName("Rut");
		cu6.setLastName("Bad");
		cu6.setEmail("dana@gmail.com");
		cu6.setPassword("1234");

		Customer cu7 = new Customer();
		cu7.setFirstName("Eden");
		cu7.setLastName("Levi");
		cu7.setEmail("avi@gmail.com");
		cu7.setPassword("1234");

		try {
			adminFacade.addCustomer(cu6);
			adminFacade.addCustomer(cu7);
			System.out.println("Add customer successful!");
		} catch (AlreadyExistException e) {
			System.out.println(e.getMessage());
		}
		CheckTitle.printCustomersTable(adminFacade.getAllCustomers());

		CheckTitle.printTestLine("Admin Facae - update customer");
		try {
			cu6.setEmail("rut123@gmail.com");
			cu6.setPassword("4321");
			adminFacade.updateCustomer(cu6);
		} catch (CannotUpdateException e) {
			System.out.println(e.getMessage());
		}
		CheckTitle.printCustomersTable(adminFacade.getAllCustomers());

		CheckTitle.printTestLine("Admin Facae - delete customer");
		try {
			adminFacade.deleteCustomer(5);
		} catch (NoSuchThingLikeThisException e) {
			System.out.println(e.getMessage());
		}
		CheckTitle.printCustomersTable(adminFacade.getAllCustomers());
		CheckTitle.printTestLine("Admin Facae - get all companies");
		CheckTitle.printCompaniesTable(adminFacade.getAllCompanies());

		CheckTitle.printTestLine("Admin Facade - get all customers");
		CheckTitle.printCustomersTable(adminFacade.getAllCustomers());

		CheckTitle.printTestLine("Admin Facade - get one company");
		CheckTitle.printOneCompany(adminFacade.getOneCompany1(4));

		CheckTitle.printTestLine("Admin Facade - get one customer");
		CheckTitle.printOneCustomer(adminFacade.getOneCustomer(2));

		CheckTitle.separatorLine();

	}

}
