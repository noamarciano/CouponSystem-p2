package com.Noam.CouponsSystem_part2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.exceptions.AlreadyExistException;
import com.Noam.CouponsSystem_part2.exceptions.CannotUpdateException;
import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;
import com.Noam.CouponsSystem_part2.exceptions.NoSuchThingLikeThisException;

@Service
public class AdminFacade extends ClientFacade {

	@Autowired
	private CompaniesService companiesService;

	@Autowired
	private CustomersService customersService;

	@Autowired
	private CouponsService couponsService;

	@Override
	public boolean login(String email, String password) throws LoginDeniedException {
		if (email.equals("admin@admin.com") && password.equals("admin")) {
			return true;
		}
		throw new LoginDeniedException("Login manager denied..");
	}

	public void addCompany(Company company) throws AlreadyExistException {
		List<Company> companies = companiesService.getAllCompanies();
		for (Company c : companies) {
			if (c.getEmail().equals(company.getEmail()) || c.getName().equals(company.getName())) {
				throw new AlreadyExistException("Sorry, Company exist");
			}
		}
		companiesService.addCompany(company);
	}

	public void updateCompany(int companyID, Company company) throws CannotUpdateException {

		if (company.getId() == companyID) {
			companiesService.updateCompany(company);
			return;
		}
		throw new CannotUpdateException("Sorry, You can't update..");
	}

	public void deleteCompany(int companyID) {
		List<Coupon> coupons = couponsService.getAllCouponsByCompanyId(companyID);
		List<Company> companies = companiesService.getAllCompanies();
		for (Coupon c : coupons) {
			if (coupons != null) {
//				couponsService.deleteCouponPurchaseByCouponID(c.getId());
				couponsService.deleteCoupon(c);
			}
		}
		for (Company company : companies) {
			if (company.getId() == companyID) {
				companiesService.deleteCompany(company);
				return;
			}
		}
		System.out.println("Sorry, There is no company with this ID (" + companyID + ") ");

	}

	public List<Company> getAllCompanies() {
		return companiesService.getAllCompanies();
	}

	public Company getOneCompany(int companyID) throws NoSuchThingLikeThisException {
		if (companiesService.getOneCompany(companyID) != null) {
			return companiesService.getOneCompany(companyID);
//		} else {
//			System.out.println("This company doesn't exist..");
//		}
		}
		throw new NoSuchThingLikeThisException("Sorry, There is no company with id : " + companyID);
	}

	public void addCustomer(Customer customer) throws AlreadyExistException {
		List<Customer> customers = customersService.getAllCustomers();
		for (Customer c : customers) {
			if (c.getEmail().equals(customer.getEmail())) {
				throw new AlreadyExistException("Sorry, Email already exist..");
			}
		}
		customersService.addCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		customersService.updateCustomer(customer);
	}

//	public void deleteCustomer(int customerID) {
//		List<Coupon> coupons = couponsService.getAllCoupons();
//		for (Coupon c : coupons) {
//			if (c.getCompanyID() == customerID) {
//				couponsService.deleteCoupon(c);
//				couponsService.deleteCouponPurchaseByCouponID(c.getId());;
//			}
//		}
//		customersService.deleteCustomer(customerID);
//	}

	public List<Customer> getAllCustomers() {
		return customersService.getAllCustomers();
	}

	public Customer getOneCustomer(int customerID) {
		if (customersService.getOneCustomer(customerID) != null) {
			return customersService.getOneCustomer(customerID);
		} else {
			System.out.println("This customer doesn't exist..");
		}
		return null;
	}

}
