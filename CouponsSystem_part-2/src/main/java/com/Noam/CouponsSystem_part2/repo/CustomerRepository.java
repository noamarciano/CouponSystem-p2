package com.Noam.CouponsSystem_part2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Noam.CouponsSystem_part2.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean findByEmailAndPassword(String email, String password);
}
