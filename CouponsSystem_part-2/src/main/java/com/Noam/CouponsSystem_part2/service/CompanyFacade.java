package com.Noam.CouponsSystem_part2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Category;
import com.Noam.CouponsSystem_part2.beans.Company;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.exceptions.AlreadyExistException;
import com.Noam.CouponsSystem_part2.exceptions.CannotUpdateException;
import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;

import lombok.Setter;

@Service
public class CompanyFacade extends ClientFacade {

	@Setter
	private int companyID;

	@Autowired
	private CompaniesService companiesService;

//	@Autowired
//	private CustomersService customersService;

	@Autowired
	private CouponsService couponsService;

	@Override
	public boolean login(String email, String password) throws LoginDeniedException {
		if (companiesService.isCompanyExist(email, password) != null) {
			return true;
		}
		throw new LoginDeniedException("Sorry, One or two things are wrong..");
	}

	public void addCoupon(Coupon coupon) throws AlreadyExistException {
		List<Coupon> coupons = couponsService.getAllCouponsByCompanyId(companyID);
		for (Coupon c : coupons) {
			if (c.getTitle().equalsIgnoreCase(coupon.getTitle())) {
				throw new AlreadyExistException("Sorry, CouponTitle already exist..");
			}
		}
		couponsService.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) throws CannotUpdateException {
		if (companyID != coupon.getCompanyID()) {
			throw new CannotUpdateException("Sorry, You can't update..");
		}
		couponsService.updateCoupon(coupon);
	}

	public void deleteCoupon(int couponID) {
		List<Coupon> coupons = couponsService.getAllCoupons();
		for (Coupon c : coupons) {
			if (c.getId() == couponID) {
//				couponsService.deleteCouponPurchaseByCouponID(couponID);
				couponsService.deleteCouponById(couponID);
				return;
			}
		}
		System.out.println("Not found matching coupons");
	}

	public List<Coupon> getCompanyCoupons() {
		if (couponsService.getAllCouponsByCompanyId(companyID) != null) {
			return couponsService.getAllCouponsByCompanyId(companyID);
		}
		System.out.println("This company doesn't have any coupons..");
		return null;
	}

	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category) {
		List<Coupon> coupons = couponsService.getAllCouponsByCompanyId(companyID);
		ArrayList<Coupon> couponsByCategory = new ArrayList<>();
		for (Coupon c : coupons) {
			if (c.getCategory().equals(category)) {
				couponsByCategory.add(c);
			}
		}
		return couponsByCategory;
	}

	public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) {
		List<Coupon> coupons = couponsService.getAllCouponsByCompanyId(companyID);
		ArrayList<Coupon> couponsByPrice = new ArrayList<>();
		for (Coupon c : coupons) {
			if (c.getPrice() <= maxPrice) {
				couponsByPrice.add(c);
			}
		}
		return couponsByPrice;

	}

	public Company getCompanyDetails() {
		Company company = companiesService.getOneCompany(companyID);
		try {
			company.setCoupons(getCompanyCoupons());
			return company;
		} catch (Exception e) {
			System.out.println("This company doesn't have coupons..");
		}
		return null;
	}

}
