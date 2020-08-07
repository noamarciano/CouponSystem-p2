package com.Noam.CouponsSystem_part2.clr;

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


@Component
@Order(6)
public class CustomerFacadeTest implements CommandLineRunner {

	@Autowired
	CustomerFacade customerFacade;
	
	@Autowired
	CouponsService couponsService;
	
	@Override
	public void run(String... args) throws Exception {
		CheckTitle.customerFacadeCheck();

//		CheckTitle.printTestLine("Customer Facade - !WRONG! login test");
//		try {
//			customerFacade = (CustomerFacade) LoginManager.login("mosh@gmail.com", "1234",
//					ClientType.Customer);
//		} catch (LoginDeniedException e) {
//			System.out.println(e.getMessage());
//		}
//
//		CheckTitle.printTestLine("Customer Facade - Real login test");
//		try {
//			customerFacade = (CustomerFacade) LoginManager.login("dana@gmail.com", "1234",
//					ClientType.Customer);
//		} catch (LoginDeniedException e) {
//			System.out.println(e.getMessage());
//		}
//		customerFacade.setCustomerID(3);

		CheckTitle.printTestLine("Customer Facade - purchase coupon");

		try {
			Coupon coupon = couponsService.getOneCoupon(5);
			CheckTitle.printOneCoupon(coupon);
			customerFacade.purchaseCoupon(coupon);
		} catch (PurchasedCouponException e) {
			System.out.println(e.getMessage());
		}

		CheckTitle.printCouponsTable(customerFacade.getCustomerCoupons());

		CheckTitle.printTestLine("Customer Facade - !WRONG! purchase coupon");

		Coupon coupon2 = couponsService.getOneCoupon(10);

		try {
			customerFacade.purchaseCoupon(coupon2);
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
