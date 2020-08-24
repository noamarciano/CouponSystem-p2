package com.Noam.CouponsSystem_part2.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Noam.CouponsSystem_part2.beans.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	List<Coupon> findByCompanyID(int companyID);
	
	public void deleteById(int id);

//	@Transactional
//	@Modifying
//	@Query(value = "from `coupon_system_2`.`customers_coupons` where `customer_id`=:`customer_id`;", nativeQuery = true)
//	List<Coupon> findByCustomerID(@Param("customer_id") int customerID);
	
//	@Query(value = " from customers_coupons where customer_id =:customer_id")
//	public List<Coupon> findByCustomerID(@Param("customer_id")int customer_id );
	
	
	//
//	@Transactional
//	@Modifying
//	@Query(value = "SELECT * FROM `coupon_system_2`.`customers_coupons` WHERE `customer_id` = ?", nativeQuery = true)
//	List<Coupon> findByCustomerID(@Param("customer_id") int customerID);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO `coupon_system_2`.`customers_coupons` (`customer_id`, `coupons_id`) VALUES (?, ?);", nativeQuery = true)
	void addCouponPurchase(@Param("customer_id") int customerID, @Param("coupons_id") int couponID);
//
//	@Transactional
//	@Modifying
//	@Query(value = "DELETE from customers_coupons WHERE customer_id=:customerID AND coupons_id=:couponID", nativeQuery = true)
//	void deleteCouponPurchase(int customerID, int couponID);
//
//	@Transactional
//	@Modifying
//	@Query(value = "DELETE from customers_coupons WHERE coupons_id=:couponID", nativeQuery = true)
//	void deleteCouponPurchaseByCouponID(int couponID);

}
