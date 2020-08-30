package com.Noam.CouponsSystem_part2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.repo.CouponRepository;

@Service
public class CouponsService {

	@Autowired
	private CouponRepository repo;

	public void addCoupon(Coupon coupon) {
		repo.save(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		repo.saveAndFlush(coupon);
	}

	public void deleteCoupon(Coupon coupon) {
		repo.delete(coupon);
	}

	public List<Coupon> getAllCoupons() {
		return repo.findAll();
	}

	public Coupon getOneCoupon(int id) {
		return repo.getOne(id);
	}

	public void deleteCouponById(int id) {
		repo.deleteById(id);
	}

	public List<Coupon> getAllCouponsByCompanyId(int companyID) {
		return repo.findByCompanyID(companyID);
	}

	public void addCouponPurchase(int customerID, int couponID) {
		repo.addCouponPurchase(customerID, couponID);
	}

	public void deleteCouponPurchase(int couponID) {
		repo.deleteCouponPurchaseByCouponID(couponID);
	}

}
