package com.Noam.CouponsSystem_part2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Category;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.beans.Customer;
import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;
import com.Noam.CouponsSystem_part2.exceptions.PurchasedCouponException;

@Service
public class CustomerFacade extends ClientFacade {

	private int customerID;

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Autowired
	private CompaniesService companiesService;

	@Autowired
	private CustomersService customersService;

	@Autowired
	private CouponsService couponsService;

	@Override
	public boolean login(String email, String password) throws LoginDeniedException {
		if (customersService.findByEmailAndPassword(email, password)) {
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
		List<Coupon> coupons = getCustomerCoupons();
		if (coupons != null) {
			for (Coupon c : coupons) {
				if (coupon.getId() == c.getId()) {
					throw new PurchasedCouponException("Coupon already purchased by this customer");
				}
			}
		}

		// You can't purchase coupon when amount=0

		if (coupon.getAmount() <= 0) {
			throw new PurchasedCouponException("Sorry, Coupon amount is less then 1");
		}

		// you can't purchase coupon when date is expired
		if (coupon.getEndDate().before(new Date())) {
			throw new PurchasedCouponException("You can't purchase coupon when date is expired");
		}
//		System.out.println(couponFromDB);
		coupon.setAmount(coupon.getAmount() - 1);
//		System.out.println(couponFromDB);
		couponsService.updateCoupon(coupon);
		couponsService.addCouponPurchase(customerID, coupon.getId());

	}

	public List<Coupon> getCustomerCoupons() {
		if (couponsService.getAllCouponsByCustomerId(customerID) != null) {
			return couponsService.getAllCouponsByCustomerId(customerID);
		} else {
			System.out.println("This customer doesn't have coupons..");
		}
		return null;
	}

	public ArrayList<Coupon> getCustomerCouponsByCategory(Category category) {// TODO need to throw exception + maxPrice
																				// + ID

		List<Coupon> coupons = new ArrayList<>();
		List<Coupon> couponsByCategory = new ArrayList<>();
		try {
			coupons = couponsService.getAllCouponsByCustomerId(customerID);
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
		List<Coupon> coupons = new ArrayList<>();
		List<Coupon> couponsByPrice = new ArrayList<>();
		try {
			coupons = couponsService.getAllCouponsByCustomerId(customerID);
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

	public Customer getCustomerDetails() {

		Customer customer = customersService.getOneCustomer(customerID);
		try {
			customer.setCoupons(getCustomerCoupons());
			return customer;
		} catch (Exception e) {
			System.out.println("This customer doesn't have coupons..");
		}
		return null;
	}

}
