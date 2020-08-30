package com.Noam.CouponsSystem_part2.clr;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.beans.Category;
import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.exceptions.LoginDeniedException;
import com.Noam.CouponsSystem_part2.exceptions.PurchasedCouponException;
import com.Noam.CouponsSystem_part2.security.ClientType;
import com.Noam.CouponsSystem_part2.security.LoginManager;
import com.Noam.CouponsSystem_part2.service.CouponsService;
import com.Noam.CouponsSystem_part2.service.CustomerFacade;
import com.Noam.CouponsSystem_part2.utils.CheckTitle;
import com.Noam.CouponsSystem_part2.utils.DateUtils;

@Component
@Order(6)
public class CustomerFacadeTest implements CommandLineRunner {

	@Autowired
	CustomerFacade customerFacade;

	@Autowired
	CouponsService couponsService;

	@Autowired
	LoginManager loginManager;

	@Override
	public void run(String... args) throws Exception {
		CheckTitle.customerFacadeCheck();

		CustomerFacade danaCustomer = null;

		CheckTitle.printTestLine("Customer Facade - !WRONG! login test");
		try {
			danaCustomer = (CustomerFacade) loginManager.login("mosh@gmail.com", "1234", ClientType.Customer);
		} catch (LoginDeniedException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printTestLine("Customer Facade - Real login test");
		danaCustomer = null;
		try {

			danaCustomer = (CustomerFacade) loginManager.login("dana@gmail.com", "1234", ClientType.Customer);
		} catch (LoginDeniedException e) {
			System.out.println(e.getMessage());
		}
		danaCustomer.setCustomerID(3);

		CheckTitle.printTestLine("Customer Facade - purchase coupon");

		Coupon coupon = new Coupon();
		coupon.setCompanyID(3);
		coupon.setCategory(Category.Electricity);
		coupon.setTitle("blala");
		coupon.setDescription("????");
		coupon.setStartDate(DateUtils.convertUtilDateToSQL(new Date(2021, 07, 15)));
		coupon.setEndDate(DateUtils.convertUtilDateToSQL(new Date(2022, 01, 17)));
		coupon.setAmount(71);
		coupon.setPrice(49);
		coupon.setImage("img.comm");

		try {
			customerFacade.purchaseCoupon(coupon);
		} catch (PurchasedCouponException e) {
			System.out.println(e.getMessage());
		}
		CheckTitle.printCouponsTable(customerFacade.getCustomerCoupons());

		CheckTitle.printTestLine("Customer Facade - !WRONG! purchase coupon (amount - 0 )");

		try {
			coupon.setAmount(0);
			customerFacade.purchaseCoupon(coupon);
		} catch (PurchasedCouponException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printCouponsTable(customerFacade.getCustomerCoupons());

		CheckTitle.printTestLine("Customer Facade - !WRONG! purchase coupon (expired)");

		try {
			coupon.setAmount(50);
			coupon.setEndDate(DateUtils.convertUtilDateToSQL(new Date(2020, 07, 23)));
			customerFacade.purchaseCoupon(coupon);
		} catch (PurchasedCouponException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printCouponsTable(customerFacade.getCustomerCoupons());

		CheckTitle.printTestLine("Customer Facade - get customer coupons");

		CheckTitle.printCouponsTable(customerFacade.getCustomerCoupons());

		CheckTitle.printTestLine("Customer Facade - get customer coupons by category");

		CheckTitle.printCouponsTable(customerFacade.getCustomerCouponsByCategory(Category.Electricity));

		CheckTitle.printTestLine("Customer Facade - !WRONG! get customer coupons by category");

		CheckTitle.printCouponsTable(customerFacade.getCustomerCouponsByCategory(Category.Food));

		CheckTitle.printTestLine("Customer Facade - get customer coupons by maxPrice");

		CheckTitle.printCouponsTable(customerFacade.getCustomerCouponsByMaxPrice(89));

		CheckTitle.printTestLine("Customer Facade - !WRONG! get customer coupons by maxPrice");

		CheckTitle.printCouponsTable(customerFacade.getCustomerCouponsByMaxPrice(4.99));

		CheckTitle.printTestLine("Customer Facade - get customer details");
		CheckTitle.printOneCustomer(customerFacade.getCustomerDetails());

		CheckTitle.separatorLine();

	}

}
