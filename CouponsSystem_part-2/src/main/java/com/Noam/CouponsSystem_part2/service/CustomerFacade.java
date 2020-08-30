package com.Noam.CouponsSystem_part2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Category;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;
import com.Noam.CouponsSystem_part2.exceptions.PurchasedCouponException;
import com.Noam.CouponsSystem_part2.repo.CustomerRepository;

import lombok.Setter;

@Service
//@Scope("prototype")
@Setter
public class CustomerFacade extends ClientFacade {

	private int customerID;

	@Autowired
	private CompaniesService companiesService;

	@Autowired
	private CustomersService customersService;

	@Autowired
	private CouponsService couponsService;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean login(String email, String password) throws LoginDeniedException {
		if (customersService.isCustomerExist(email, password) != null) {
			return true;
		}
		throw new LoginDeniedException("Sorry, Login denied..");
	}

	public void purchaseCoupon(Coupon coupon) throws PurchasedCouponException {

		if (coupon == null) {
			throw new PurchasedCouponException("This coupon does not exist");
		} else if (couponsService.getOneCoupon(coupon.getId()) == null) {
			throw new PurchasedCouponException("This id does not exist");
		}

		// You can't purchase coupon more than once

		if (getCustomerCoupons().contains(coupon)) {
			throw new PurchasedCouponException("Coupon already purchased by this customer");
		}

		// You can't purchase coupon when amount=0

		if (coupon.getAmount() == 0) {
			throw new PurchasedCouponException("Sorry, Coupon amount is less then 1");
		}

		// you can't purchase coupon when date is expired
		if (coupon.getEndDate().before(new Date())) {
			throw new PurchasedCouponException("You can't purchase coupon when date is expired");
		}
		coupon.setAmount(coupon.getAmount() - 1);
		couponsService.updateCoupon(coupon);
		couponsService.addCouponPurchase(customerID, coupon.getId());

	}

	public List<Coupon> getCustomerCoupons() {
		Optional<Customer> customer = customersService.getOneCustomer(customerID);
		List<Coupon> coupons = customer.get().getCoupons();
		if (coupons == null) {
			System.out.println("This customer doesn't have coupons..");
			return null;
		}
		return coupons;
	}

	public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) {
		List<Coupon> couponsByCategory = new ArrayList<>();
		try {
			Optional<Customer> customer = customersService.getOneCustomer(customerID);
			List<Coupon> coupons = customer.get().getCoupons();
			for (Coupon c : coupons) {
				if (c.getCategory().equals(category)) {
					couponsByCategory.add(c);
				}
			}
			return (ArrayList<Coupon>) couponsByCategory;
		} catch (Exception e) {
			System.out.println("This customer doesn't have coupons with this category..");
		}
		return null;
	}

	public ArrayList<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
		List<Coupon> couponsByPrice = new ArrayList<>();
		try {
			Optional<Customer> customer = customersService.getOneCustomer(customerID);
			List<Coupon> coupons = customer.get().getCoupons();
			for (Coupon c : coupons) {
				if (c.getPrice() < maxPrice) {
					couponsByPrice.add(c);
				}
			}

			return (ArrayList<Coupon>) couponsByPrice;
		} catch (Exception e) {
			System.out.println("This customer doesn't have coupons..");
		}
		return null;
	}

	public Optional<Customer> getCustomerDetails() {

		Optional<Customer> customer = customersService.getOneCustomer(customerID);
		try {
			customer.get().setCoupons(getCustomerCoupons());
			return customer;
		} catch (Exception e) {
			System.out.println("This customer doesn't have coupons..");
		}
		return null;
	}

}
