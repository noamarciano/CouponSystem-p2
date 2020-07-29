package com.Noam.CouponsSystem_part2.clr;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.beans.Category;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.service.CouponsService;
import com.Noam.CouponsSystem_part2.utils.CheckTitle;
import com.Noam.CouponsSystem_part2.utils.DateUtils;

@Component
@Order(3)
public class CouponsServiceTest implements CommandLineRunner {

	@Autowired
	CouponsService couponsService;

	@Override
	public void run(String... args) throws Exception {

		CheckTitle.couponsServicecheck();

		Coupon cou1 = new Coupon();
		cou1.setCompanyID(1);
		cou1.setCategory(Category.Vacation);
		cou1.setTitle("10%");
		cou1.setDescription("get 10% off");
		cou1.setStartDate(DateUtils.calcDate(20, 07, 2020));// TODO need to fix the date to print without time.
		cou1.setEndDate(DateUtils.calcDate(07, 10, 2020));
		cou1.setAmount(70);
		cou1.setPrice(250);
		cou1.setImage("img.com");

		Coupon cou2 = new Coupon();
		cou2.setCompanyID(2);
		cou2.setCategory(Category.Electricity);
		cou2.setTitle("50%");
		cou2.setDescription("discount 50%");
		cou2.setStartDate(DateUtils.calcDate(15, 02, 2021));
		cou2.setEndDate(DateUtils.calcDate(12, 04, 2021));
		cou2.setAmount(100);
		cou2.setPrice(39.9);
		cou2.setImage("img.com");

		Coupon cou3 = new Coupon();
		cou3.setCompanyID(3);
		cou3.setCategory(Category.Food);
		cou3.setTitle("happy hour");
		cou3.setDescription("buy one, get two");
		cou3.setStartDate(DateUtils.calcDate(30, 06, 2020));
		cou3.setEndDate(DateUtils.calcDate(05, 07, 2020));
		cou3.setAmount(50);
		cou3.setPrice(50);
		cou3.setImage("img.com");

		CheckTitle.printTestLine("add coupon");
		couponsService.addCoupon(cou1);
		couponsService.addCoupon(cou2);
		couponsService.addCoupon(cou3);
		CheckTitle.printCouponsTable(couponsService.getAllCoupons());

		CheckTitle.printTestLine("update coupon");
		cou2.setAmount(200);
		cou2.setPrice(79);
		couponsService.updateCoupon(cou2);
		CheckTitle.printOneCoupon(couponsService.getOneCoupon(2));

		CheckTitle.printTestLine("delete coupon");
		couponsService.deleteCoupon(cou1);
		CheckTitle.printCouponsTable(couponsService.getAllCoupons());

		CheckTitle.printTestLine("get all coupons");
		CheckTitle.printCouponsTable(couponsService.getAllCoupons());

		CheckTitle.printTestLine("get one coupon");
		CheckTitle.printOneCoupon(couponsService.getOneCoupon(2));
		System.out.println();

		CheckTitle.separatorLine();

	}

}
