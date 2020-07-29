package com.Noam.CouponsSystem_part2.clr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.service.CompaniesService;
import com.Noam.CouponsSystem_part2.utils.CheckTitle;

@Component
@Order(1)
public class CompaniesServiceTest implements CommandLineRunner {

	@Autowired
	CompaniesService companiesService;

	@Override
	public void run(String... args) throws Exception {

		CheckTitle.companiesServicecheck();

		Company c1 = new Company();
		c1.setName("Osem");
		c1.setEmail("osem@company.com");
		c1.setPassword("1234");

		Company c2 = new Company();
		c2.setName("Samsung");
		c2.setEmail("samsung@company.com");
		c2.setPassword("1234");

		Company c3 = new Company();
		c3.setName("Burger King");
		c3.setEmail("burgerking@company.com");
		c3.setPassword("1234");

		CheckTitle.printTestLine("add companies");
		companiesService.addCompany(c1);
		companiesService.addCompany(c2);
		companiesService.addCompany(c3);
		CheckTitle.printCompaniesTable(companiesService.getAllCompanies());

		CheckTitle.printTestLine("check if company exist");//// Should return true
		System.out.println(companiesService.findByEmailAndPassword("osem@company.com", "1234"));

//			CheckTitle.printTestLine("!WRONG! check if company exist");// Should return false
//			System.out.println(companiesDBDAO.isCompanyExists("osem111@company.com", "1234"));

		CheckTitle.printTestLine("update company");
		c2.setPassword("4321");
		c2.setEmail("samsung1111@company.com");
		companiesService.updateCompany(c2);
		CheckTitle.printOneCompany(companiesService.getOneCompany(2));

		CheckTitle.printTestLine("delete company");
		companiesService.deleteCompany(c1);
		CheckTitle.printCompaniesTable(companiesService.getAllCompanies());

		CheckTitle.printTestLine("get all companies");
		CheckTitle.printCompaniesTable(companiesService.getAllCompanies());

		CheckTitle.printTestLine("get one comapany");
		CheckTitle.printOneCompany(companiesService.getOneCompany(2));

		CheckTitle.separatorLine();

	}

}
