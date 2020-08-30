package com.Noam.CouponsSystem_part2.schedule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Noam.CouponsSystem_part2.beans.Coupon;
import com.Noam.CouponsSystem_part2.service.CompanyFacade;
import com.Noam.CouponsSystem_part2.service.CouponsService;

@Component
public class DailyJob implements Runnable {

	@Autowired
	private CouponsService couponsService;

	@Autowired
	private CompanyFacade companyFacade;

	private boolean quit = false;

	public DailyJob() {
		super();
	}

	@Scheduled(fixedDelay = 1000 * 10)
	@Override
	public void run() {

		while (!quit) {
			List<Coupon> coupons = couponsService.getAllCoupons();
			for (Coupon coupon : coupons) {
				if (coupon.getEndDate().before(new Date())) {
					System.out.println("Coupon " + coupon.getId() + " deleted");
					companyFacade.deleteCoupon(coupon.getId());
				}
			}
			try {
				Thread.sleep(2 * 1000);
			} catch (Exception e) {
				return;
			}
		}
	}

	public void stopJob() {
		this.quit = true;
		System.out.println("DailyJob is stopped");

	}

}
