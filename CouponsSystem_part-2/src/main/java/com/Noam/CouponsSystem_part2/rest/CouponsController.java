package com.Noam.CouponsSystem_part2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.service.CouponsService;

@RestController
@RequestMapping("coupon")
public class CouponsController {

	@Autowired
	CouponsService couponsService;

	@PostMapping("add")
	public ResponseEntity<?> addCoupon(Coupon coupon) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("update")
	public ResponseEntity<?> updateCoupon(Coupon coupon) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> deleteCoupon(Coupon coupon) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("get-all")
	public ResponseEntity<?> getAllCoupons() {
		return new ResponseEntity<List<Coupon>>(couponsService.getAllCoupons(), HttpStatus.OK);
	}

	@GetMapping("get-one")
	public ResponseEntity<?> getOneCoupon(int id) {
		return new ResponseEntity<Coupon>(couponsService.getOneCoupon(id), HttpStatus.OK);
	}

}
