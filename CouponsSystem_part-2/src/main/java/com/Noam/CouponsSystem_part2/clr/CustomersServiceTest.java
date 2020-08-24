package com.Noam.CouponsSystem_part2.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.service.CustomersService;
import com.Noam.CouponsSystem_part2.utils.CheckTitle;

@Component
@Order(2)
public class CustomersServiceTest implements CommandLineRunner {

	@Autowired
	CustomersService customersService;

	@Override
	public void run(String... args) throws Exception {

		CheckTitle.customersServicecheck();

		Customer cu1 = new Customer();
		cu1.setFirstName("Koby");
		cu1.setLastName("Shasha");
		cu1.setEmail("koby@gmail.com");
		cu1.setPassword("1234");

		Customer cu2 = new Customer();
		cu2.setFirstName("Noam");
		cu2.setLastName("Marciano");
		cu2.setEmail("noam@gmail.com");
		cu2.setPassword("1234");

		Customer cu3 = new Customer();
		cu3.setFirstName("Orit");
		cu3.setLastName("Cohen");
		cu3.setEmail("orit@gmail.com");
		cu3.setPassword("1234");

		CheckTitle.printTestLine("add customer");

		customersService.addCustomer(cu1);
		customersService.addCustomer(cu2);
		customersService.addCustomer(cu3);
		CheckTitle.printCustomersTable(customersService.getAllCustomers());

		CheckTitle.printTestLine("check if customer exist");// Should return true
		System.out.println(customersService.isCustomerExist("koby@gmail.com", "1234"));
////
////			CheckTitle.printTestLine("!WRONG! check if customer exist");//// Should return false
////			System.out.println(customersDBDAO.isCustomerExists("koby@gmail.com", "1111"));
//
		CheckTitle.printTestLine("update customer");
		cu2.setPassword("4321");
		cu2.setFirstName("Eliyahu");
		customersService.updateCustomer(cu2);
		CheckTitle.printOneCustomer(customersService.getOneCustomer(2));

		CheckTitle.printTestLine("delete customer");
		customersService.deleteCustomer(cu1);
		CheckTitle.printCustomersTable(customersService.getAllCustomers());

		CheckTitle.printTestLine("get all customers");
		CheckTitle.printCustomersTable(customersService.getAllCustomers());

		CheckTitle.printTestLine("get one customer");
		CheckTitle.printOneCustomer(customersService.getOneCustomer(2));

		CheckTitle.separatorLine();

	}

}
